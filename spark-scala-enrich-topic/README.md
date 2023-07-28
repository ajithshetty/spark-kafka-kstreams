# Kafka Streams > Spark Streaming > Kafka Streams pipeline

This Project is mainly focused on how we can integrate Kafka Streams with Scala Spark and Vice-Versa.

We will be using the Bank transaction as our example.

The Goals are as follows:
1. Create Kafka Streams which consists of bank transactions, backed by Schema Registry
2. Split the Bank transaction based on the withdrawal amount.
    - If withdrawal < Balance: Write to APPROVED Topic
    - If withdrawal > Balance: Write to REJECTED Topic
3. Read the REJECTED TOPIC using Scala Spark, with the same Avro schema created in the step 1.
4. Aggregate the records by Account ID and write to AGGREGATED Topic.
5. Kafka Streams Read the AGGREGATED Topic and write to ANALYSIS Topic for further analysis downstream

## Architecture
Image Here

## Setting up properties for running the exercise code
For easy setup we have the fully ready docker-compose.yaml file which will bring up the necessary containers.

We have all the default configurations defined in a file:

`src/main/resources/streams.properties`


## Running the exercises

Run the below script to start the containers

`sh start_containers.sh`

The first step before working with any of streams exercises will be to run `./gradlew build` to make generate all of the
Avro objects from the schemas contained in the `/src/main/avro` directory.

The exercises are self-contained and can be run independently of any other exercise.  To increase the visibility of the running code
logging for the exercise will get output to `logs/kafka_streams_course.log`.  The `log4j2.properties` file is set to 
**_not append_** so each run of an exercise will wipe out the logs for a previous run.

Each streams application will print the records coming into the topology, and the records going out of the topology. Also, 
some streams applications will print to the console from different handlers.  To that end, you should let each application run
for at least 40 seconds, as some of them don't have immediate output.

Every application uses utility class,
`TopologyLoader`, which will create the required topics and populate them with some sample data.

Finally, to run an exercise from the command line (assuming you are in the root directory of the repo) run the following 
command:

`./gradlew runStreams -Pargs=`[bankwritespark](src/main/java/io/confluent/developer/bankspark/README.md)

```text
Record produced - offset - 0 timestamp - 1690543334146
Record produced - offset - 1 timestamp - 1690543344146
Record produced - offset - 2 timestamp - 1690543354146
Record produced - offset - 3 timestamp - 1690543364146
Record produced - offset - 4 timestamp - 1690543374146
Record produced - offset - 5 timestamp - 1690543384146
Incoming record - key 1001 value {"account_id": 1001, "time": 1690543334146, "withdraw": 100.0, "balance": 1000.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1001 value {"account_id": 1001, "time": 1690543334146, "withdraw": 100.0, "balance": 900.0, "bank_transaction_state": "APPROVED"}
Approved record - key 1001 value {"account_id": 1001, "time": 1690543334146, "withdraw": 100.0, "balance": 900.0, "bank_transaction_state": "APPROVED"}
Incoming record - key 1002 value {"account_id": 1002, "time": 1690543344146, "withdraw": 200.0, "balance": 1000.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1002 value {"account_id": 1002, "time": 1690543344146, "withdraw": 200.0, "balance": 800.0, "bank_transaction_state": "APPROVED"}
Approved record - key 1002 value {"account_id": 1002, "time": 1690543344146, "withdraw": 200.0, "balance": 800.0, "bank_transaction_state": "APPROVED"}
Incoming record - key 1003 value {"account_id": 1003, "time": 1690543354146, "withdraw": 300.0, "balance": 300.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1003 value {"account_id": 1003, "time": 1690543354146, "withdraw": 300.0, "balance": 300.0, "bank_transaction_state": "REJECTED"}
Rejected record - key 1003 value {"account_id": 1003, "time": 1690543354146, "withdraw": 300.0, "balance": 300.0, "bank_transaction_state": "REJECTED"}
Incoming record - key 1004 value {"account_id": 1004, "time": 1690543364146, "withdraw": 800.0, "balance": 1000.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1004 value {"account_id": 1004, "time": 1690543364146, "withdraw": 800.0, "balance": 200.0, "bank_transaction_state": "APPROVED"}
Approved record - key 1004 value {"account_id": 1004, "time": 1690543364146, "withdraw": 800.0, "balance": 200.0, "bank_transaction_state": "APPROVED"}
Incoming record - key 1005 value {"account_id": 1005, "time": 1690543374146, "withdraw": 500.0, "balance": 1000.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1005 value {"account_id": 1005, "time": 1690543374146, "withdraw": 500.0, "balance": 500.0, "bank_transaction_state": "APPROVED"}
Approved record - key 1005 value {"account_id": 1005, "time": 1690543374146, "withdraw": 500.0, "balance": 500.0, "bank_transaction_state": "APPROVED"}
Incoming record - key 1006 value {"account_id": 1006, "time": 1690543384146, "withdraw": 500.0, "balance": 2000.0, "bank_transaction_state": "CREATED"}
Outgoing record - key 1006 value {"account_id": 1006, "time": 1690543384146, "withdraw": 500.0, "balance": 1500.0, "bank_transaction_state": "APPROVED"}
Approved record - key 1006 value {"account_id": 1006, "time": 1690543384146, "withdraw": 500.0, "balance": 1500.0, "bank_transaction_state": "APPROVED"}
```


Each execution of `runStreams` will build the project first.  Each streams application will continue to run after you have started it, so once you are done
enter a `CTRL+C` from the keyboard to shut it down.

## 2. Spark Streaming
We need to copy the avro file for our example BANK:

#### from the source project path src/main/avro/bank.avsc
#### to spark-scala-enrich-topic/src/main/resources/bank.avsc

Update the topic names and spark properties:
#### spark-scala-enrich-topic/src/main/resources/input.properties


Under the project path: `spark-scala-enrich-topic`

Run the below scripts:

`sh build.sh`  To build the Fat Jar

`sh submit.sh`  To submit the job under the Spark Container


## Output
```text
23/07/28 11:31:10 INFO MicroBatchExecution: Streaming query made progress: {
  "id" : "30890a52-4498-452e-8465-396248cae694",
  "runId" : "87b2b9e7-49bc-4d0e-86e1-de704e4f1205",
  "name" : null,
  "timestamp" : "2023-07-28T11:31:10.187Z",
  "batchId" : 1,
  "numInputRows" : 0,
  "inputRowsPerSecond" : 0.0,
  "processedRowsPerSecond" : 0.0,
  "durationMs" : {
    "latestOffset" : 7,
    "triggerExecution" : 7
  },
  "stateOperators" : [ {
    "operatorName" : "stateStoreSave",
    "numRowsTotal" : 1,
    "numRowsUpdated" : 0,
    "allUpdatesTimeMs" : 512,
    "numRowsRemoved" : 0,
    "allRemovalsTimeMs" : 0,
    "commitTimeMs" : 1163,
    "memoryUsedBytes" : 704,
    "numRowsDroppedByWatermark" : 0,
    "numShufflePartitions" : 2,
    "numStateStoreInstances" : 2,
    "customMetrics" : {
      "loadedMapCacheHitCount" : 0,
      "loadedMapCacheMissCount" : 0,
      "stateOnCurrentVersionSizeBytes" : 416
    }
  } ],
  "sources" : [ {
    "description" : "KafkaV2[Subscribe[bank-spark-rejected-streams11]]",
    "startOffset" : {
      "bank-spark-rejected-streams11" : {
        "0" : 1
      }
    },
    "endOffset" : {
      "bank-spark-rejected-streams11" : {
        "0" : 1
      }
    },
    "latestOffset" : {
      "bank-spark-rejected-streams11" : {
        "0" : 1
      }
    },
    "numInputRows" : 0,
    "inputRowsPerSecond" : 0.0,
    "processedRowsPerSecond" : 0.0,
    "metrics" : {
      "avgOffsetsBehindLatest" : "0.0",
      "maxOffsetsBehindLatest" : "0",
      "minOffsetsBehindLatest" : "0"
    }
  } ],
  "sink" : {
    "description" : "org.apache.spark.sql.kafka010.KafkaSourceProvider$KafkaTable@4a5c567b",
    "numOutputRows" : 0
  }
}
```

`./gradlew runStreams -Pargs=`[bankreadspark](src/main/java/io/confluent/developer/bankspark/README.md)
```text
Incoming Spark record - key 1003 value 300.0
Outgoing Spark record - key 1003 value 300.0
```
