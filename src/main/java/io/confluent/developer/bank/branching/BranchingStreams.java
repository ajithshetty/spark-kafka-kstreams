package io.confluent.developer.bank.branching;

import io.confluent.common.utils.TestUtils;
import io.confluent.developer.avro.Bank;
import io.confluent.developer.avro.state;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class BranchingStreams {

    public static Topology buildTopology(Properties allProps,
                                         final SpecificAvroSerde<Bank> bankSpecificAvroSerde){

        final StreamsBuilder builder=new StreamsBuilder();

        final String inputTopic = allProps.getProperty("bank.branch.input.topic");
        final String approvedTopic = allProps.getProperty("bank.branch.approved.topic");
        final String rejectedTopic = allProps.getProperty("bank.branch.rejected.topic");
        final String mergedTopic = allProps.getProperty("bank.branch.merged.topic");

        final KStream<Long,Bank> bankKStream=builder.stream(inputTopic, Consumed.with(Serdes.Long(),bankSpecificAvroSerde));
        bankKStream.peek((key, value) ->System.out.println("Incoming record - key " + key + " value " + value));


        KStream<Long, Bank> bankBalancesStream=bankKStream
                .filter(
                        (key, value) -> {
                            if(value.getBalance()<=value.getWithdraw()){
                                value.setBankTransactionState(state.REJECTED);
                            }else{
                                value.setBalance(value.getBalance()-value.getWithdraw());
                                value.setBankTransactionState(state.APPROVED);
                            }
                            return true;
                        });

        bankBalancesStream.peek((key, value) -> System.out.println("Outgoing record - key " + key + " value " + value));

        Map<String,KStream<Long, Bank>> branches= bankBalancesStream.split()
                .branch((key, value) -> value.getBankTransactionState()== state.APPROVED, Branched.as("APPROVED"))
                .branch((key, value) -> value.getBankTransactionState()== state.REJECTED, Branched.as("REJECTED"))
                .noDefaultBranch();

        branches.get("REJECTED")
                .peek((key, value) -> System.out.println("Outgoing REJECTED record - key " + key + " value " + value))
                .to(rejectedTopic);

        branches.get("REJECTED").merge(branches.get("APPROVED"))
                .peek((key, value) -> System.out.println("Outgoing MERGED record - key " + key + " value " + value))
                .to(mergedTopic);

        branches.get("APPROVED")
                .peek((key, value) -> System.out.println("Outgoing APPROVED record - key " + key + " value " + value))
                .to(approvedTopic);

        return builder.build();
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
        allProps.put(StreamsConfig.APPLICATION_ID_CONFIG, allProps.getProperty("bank.branch.application.id"));
        allProps.put(StreamsConfig.STATE_DIR_CONFIG, TestUtils.tempDirectory().getPath());
        allProps.put("bank.branch.input.topic", allProps.getProperty("bank.branch.input.topic"));
        allProps.put("bank.branch.approved.topic", allProps.getProperty("bank.branch.approved.topic"));
        allProps.put("bank.branch.rejected.topic", allProps.getProperty("bank.branch.rejected.topic"));
        allProps.put("bank.branch.merged.topic", allProps.getProperty("bank.branch.merged.topic"));

        TopicLoader.runProducer();

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

