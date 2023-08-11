package io.confluent.developer.bank.branching;

import io.confluent.developer.StreamsUtils;
import io.confluent.developer.avro.Bank;
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
            Producer<Long, Bank> producer = new KafkaProducer<>(properties)) {
            final String inputTopic = properties.getProperty("bank.branch.input.topic");
            final String approvedTopic = properties.getProperty("bank.branch.approved.topic");
            final String rejectedTopic = properties.getProperty("bank.branch.rejected.topic");
            final String mergedTopic = properties.getProperty("bank.branch.merged.topic");
            List<NewTopic> topics = Arrays.asList(
                    StreamsUtils.createTopic(inputTopic),
                    StreamsUtils.createTopic(approvedTopic),
                    StreamsUtils.createTopic(rejectedTopic),
                    StreamsUtils.createTopic(mergedTopic));
            adminClient.createTopics(topics);


            Callback callback = StreamsUtils.callback();

            Instant instant = Instant.now();

            List<Bank> data = List.of(
                    Bank.newBuilder()
                            .setAccountId(1001)
                            .setTime(instant.toEpochMilli())
                            .setBalance(1000)
                            .setWithdraw(100)
                            .setBankTransactionState(state.CREATED)
                            .build(),
                    Bank.newBuilder()
                            .setAccountId(1002)
                            .setTime(instant.plusSeconds(10L).toEpochMilli())
                            .setBalance(1000)
                            .setWithdraw(200)
                            .setBankTransactionState(state.CREATED)
                            .build(),
                    Bank.newBuilder()
                            .setAccountId(1003)
                            .setTime(instant.plusSeconds(20L).toEpochMilli())
                            .setBalance(300)
                            .setWithdraw(300)
                            .setBankTransactionState(state.CREATED)
                            .build(),
                    Bank.newBuilder()
                            .setAccountId(1004)
                            .setTime(instant.plusSeconds(30L).toEpochMilli())
                            .setBalance(100)
                            .setWithdraw(800)
                            .setBankTransactionState(state.CREATED)
                            .build(),
                    Bank.newBuilder()
                            .setAccountId(1005)
                            .setTime(instant.plusSeconds(40L).toEpochMilli())
                            .setBalance(1000)
                            .setWithdraw(500)
                            .setBankTransactionState(state.CREATED)
                            .build(),
                    Bank.newBuilder()
                            .setAccountId(1006)
                            .setTime(instant.plusSeconds(50L).toEpochMilli())
                            .setBalance(2000)
                            .setWithdraw(500)
                            .setBankTransactionState(state.CREATED)
                            .build()
            );

            data.forEach((bankTransaction -> {
                ProducerRecord<Long, Bank> producerRecord = new ProducerRecord<>(
                        inputTopic,
                        0,
                        bankTransaction.getTime(),
                        bankTransaction.getAccountId(),
                        bankTransaction);
                producer.send(producerRecord, callback);
            }));



        }
    }
}
