# Spark Kafka KStreams

This repo comprises multiple sections.
1. Kafka Kstreams
2. Spark Streaming
3. Kstreams with Schema Registry
4. Connect KStreams with Spark Streaming
5. Connect Spark Streaming with KStreams
6. KAFKA-UI to monitor manage Kafka easily


##Target Audience
The main focus of this repo is to help everyone who are looking to learn KAFKA with Kstreams and Spark Streaming.
We take away all the abstraction of setting up the resources and running different services.
And we have provided with the use cases and examples which can be run individually and as well as a group.

## 1. Kafka Kstreams

This section is cloned from [learn-kafka-courses](https://github.com/confluentinc/learn-kafka-courses/tree/main)
And we will only be working on submodule [kafka-streams](https://github.com/confluentinc/learn-kafka-courses/tree/main/kafka-streams)

We have extended the Above repo to have our specific requirements and added few extra modules.

## 2. Spark Streaming

We have multiple example and use cases with Spark Streaming.

|Sub Projects                                                                               |
| ----------------------------------------------------------------------------------------- |
|[spark-python](spark-kafka-kstreams/spark-python/README.md)                                |
|[spark-scala](spark-kafka-kstreams/spark-scala/README.md)                                  |
|[spark-scala-enrich-topic](spark-kafka-kstreams/spark-scala-enrich-topic/README.md)        |
|[spark-scala-functions](spark-kafka-kstreams/spark-scala-functions/README.md)              |
|[spark-scala-schema-registry](spark-kafka-kstreams/spark-scala-schema-registry/README.md)  |

## 3. KAFKA-UI
This [project](spark-kafka-kstreams/kafka-ui/README.md) is to help Kafka developers to manage there clusters with UI.
Using KAFKA-UI you can take advantage of all the maintenance and monitoring capabilities of Kafka using a click of a button.

[Reading KStreams using Spark and Vice versa](src/main/java/io/confluent/developer/bankspark/README.md)