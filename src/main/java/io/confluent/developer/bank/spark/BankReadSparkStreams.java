package io.confluent.developer.bank.spark;

import io.confluent.common.utils.TestUtils;
import io.confluent.demo.CountAndSum;
import io.confluent.developer.avro.Bank;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class BankReadSparkStreams {

    public static Topology buildTopology(Properties allProps,
                                         final SpecificAvroSerde<Bank> bankSpecificAvroSerde){

        final StreamsBuilder builder=new StreamsBuilder();

        final String sparkInputTopic = allProps.getProperty("bank.spark.aggregated.topic");
        final String sparkOutputTopic = allProps.getProperty("bank.spark.analysis.topic");

        final KStream<String,String> bankKStream=builder.stream(sparkInputTopic, Consumed.with(Serdes.String(),Serdes.String()));
        bankKStream.peek((key, value) ->System.out.println("Incoming Spark record - key " + key + " value " + value));


        bankKStream
        .peek((key, value) -> System.out.println("Outgoing Spark record - key " + key + " value " + value))
                .to(sparkOutputTopic);

        return builder.build();
    }

    public static SpecificAvroSerde<CountAndSum> getCountAndSumSerde(Properties allProps) {
        SpecificAvroSerde<CountAndSum> serde = new SpecificAvroSerde<>();
        Map<String,String> config= new HashMap<>();
        config.put("schema.registry.url",allProps.getProperty("schema.registry.url"));
        serde.configure(config,false);
        return serde;
    }

    private static SpecificAvroSerde<Bank> bankSerde(final Properties allProps){
        final SpecificAvroSerde<Bank> serde= new SpecificAvroSerde<>();
        Map<String,String> config= new HashMap<>();
        config.put("schema.registry.url",allProps.getProperty("schema.registry.url"));
        serde.configure(config,false);
        return serde;
    }

    public static void main(String[] args) throws IOException {

        final Properties allProps = new Properties();
        try (InputStream inputStream = new FileInputStream("src/main/resources/streams.properties")) {
            allProps.load(inputStream);
        }
        allProps.put(StreamsConfig.APPLICATION_ID_CONFIG, allProps.getProperty("bank.application.id"));
        allProps.put(StreamsConfig.STATE_DIR_CONFIG, TestUtils.tempDirectory().getPath());
        allProps.put("bank.input.topic", allProps.getProperty("bank.input.topic"));
        allProps.put("bank.output.topic", allProps.getProperty("bank.output.topic"));

        //TopicLoader.runProducer();

        Topology topology = buildTopology(allProps, bankSerde(allProps));

        try (KafkaStreams kafkaStreams = new KafkaStreams(topology, allProps)) {
            final CountDownLatch shutdownLatch = new CountDownLatch(1);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                kafkaStreams.close(Duration.ofSeconds(2));
                shutdownLatch.countDown();
            }));
            try {
                kafkaStreams.start();
                shutdownLatch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
        System.exit(0);
    }

}

