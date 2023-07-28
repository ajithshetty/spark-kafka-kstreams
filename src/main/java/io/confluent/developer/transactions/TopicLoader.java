package io.confluent.developer.transactions;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.Bank;
import io.confluent.developer.avro.Transactions;
import io.confluent.developer.avro.state;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TopicLoader {

    public static void main(String[] args) throws IOException {
        runProducer();
    }

    public static void runProducer() throws IOException {
        Properties properties = StreamsUtils.loadProperties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

        try(Admin adminClient = Admin.create(properties);
            Producer<Long, Transactions> producer = new KafkaProducer<>(properties)) {
            final String inputTopic = properties.getProperty("transactions.input.topic");
            final String outputTopic = properties.getProperty("transactions.output.topic");

            List<NewTopic> topics = Arrays.asList(
                    StreamsUtils.createTopic(inputTopic),
                    StreamsUtils.createTopic(outputTopic));
            adminClient.createTopics(topics);


            Callback callback = StreamsUtils.callback();

            Instant instant = Instant.now();

            List<Transactions> data = List.of(
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1001)
                            .setJobLevel(1)
                            .setCreatedBy("user1")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1002)
                            .setJobLevel(1)
                            .setCreatedBy("user1")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1003)
                            .setJobLevel(2)
                            .setCreatedBy("user2")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1004)
                            .setJobLevel(3)
                            .setCreatedBy("user3")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1005)
                            .setJobLevel(4)
                            .setCreatedBy("user4")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1006)
                            .setJobLevel(4)
                            .setCreatedBy("user4")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1007)
                            .setJobLevel(4)
                            .setCreatedBy("user4")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1008)
                            .setJobLevel(5)
                            .setCreatedBy("user5")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1009)
                            .setJobLevel(6)
                            .setCreatedBy("user6")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build(),
                    Transactions.newBuilder()
                            .setTime(instant.plusSeconds(5l).toEpochMilli())
                            .setTransactionId(1010)
                            .setJobLevel(6)
                            .setCreatedBy("user6")
                            .setCreatedDate(instant.plusSeconds(5l).toEpochMilli())
                            .build()

            );

            data.forEach((transaction -> {
                ProducerRecord<Long, Transactions> producerRecord = new ProducerRecord<>(
                        inputTopic,
                        0,
                        transaction.getTime(),
                        transaction.getTransactionId(),
                        transaction);
                producer.send(producerRecord, callback);
            }));



        }
    }
}
