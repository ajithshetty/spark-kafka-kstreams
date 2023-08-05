# Beyond Streaming

## Integration of Kafka, KStreams, Spark, Schema Registry, Kafka-UI and many more

## Target Audience
The main focus of this repo is to help everyone who are looking to learn KAFKA with Kstreams and Spark Streaming.
We take away all the abstraction of setting up the resources and running different services.
And we have provided with the use cases and examples which can be run individually and as well as a group.

This repo comprises multiple sections.
1. Kafka
   - KStreams
   - KsqlDB
   - Kafka Connect
   - Kafka Schema Registry
   - Kafka REST
2. Spark Streaming
   - Connect KStreams with Spark Streaming
   - Connect Spark Streaming with KStreams with Avro Schema
6. KAFKA-UI to monitor manage Kafka easily

## Architecture
Image Here

## Setting up the Docker
To help you use these projects we will be bringing up below set of containers.

|Sub Projects                                                                                       | Details          |
| ------------------------------------------------------------------------------------------------- | ---------------- |
|[Zoo-Keeper](https://zookeeper.apache.org/)                                                        | Zookeeper is used by Kafka brokers to determine which broker is the leader of a given partition and topic and perform leader elections                 |
|[Broker](https://kafka.apache.org/documentation/)                                                  | A Kafka cluster is a group of multiple Kafka brokers.                  |
|[Schema Registry](https://github.com/confluentinc/schema-registry)                                 | Schema Registry provides a centralized repository for managing and validating schemas for topic message data, and for serialization and deserilazation of the data over the network                 |
|[Rest Proxy](https://github.com/confluentinc/kafka-rest)                                           | The Confluent REST Proxy provides a RESTful interface to an Apache Kafka® cluster, making it easy to produce and consume messages, view the state of the cluster, and perform administrative actions without using the native Kafka protocol or clients.                 |
|[Spark Master](https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html)   |  Apache Spark™ is a multi-language engine for executing data engineering, data science, and machine learning on single-node machines or clusters.                |
|[Spark worker-1](https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html) |                  |
|[Spark worker-2](https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html) |                  |
|[Kafka UI](https://github.com/provectus/kafka-ui)                                                  | UI for Apache Kafka is a free, open-source web UI to monitor and manage Apache Kafka clusters.|
|[KsqlDB Server](https://docs.ksqldb.io/en/latest/operate-and-deploy/installation/server-config/)   | ksqlDB is an event streaming database for Apache Kafka. It is distributed, scalable, reliable, and real-time.                 |
|[KsqlDB CLI](https://docs.ksqldb.io/en/latest/operate-and-deploy/installation/cli-config/)         | ksqlDB CLI to one ksqlDB server per cluster.                 |
|[Datagen](https://www.confluent.io/blog/easy-ways-generate-test-data-kafka/)                       | Generating data|
|[Kafka Connect](https://www.confluent.io/blog/kafka-connect-tutorial/)                             | Kafka Connect is a free, open-source component of Apache Kafka® that serves as a centralized data hub for simple data integration between databases, key-value stores, search indexes, and file systems                 |
|[MINIO](https://github.com/minio/minio)                                                            | inIO is a high-performance, S3 compatible object store. It is built for large scale AI/ML, data lake and database workloads. It runs on-prem and on any cloud (public or private) and from the data center to the edge.                 |

## Setting up properties for running the exercise code
For easy setup we have the fully ready docker-compose.yaml file which will bring up the necessary containers.

We have all the default configurations defined in a file:

`src/main/resources/streams.properties`


## Running the exercises

Run the below script to start the containers

`sh start_containers.sh`
## 1. Kafka Kstreams

This section is cloned from [learn-kafka-courses](https://github.com/confluentinc/learn-kafka-courses/tree/main)
And we will only be working on submodule [kafka-streams](https://github.com/confluentinc/learn-kafka-courses/tree/main/kafka-streams)

We have extended the Above repo to have our specific requirements and added few extra modules.

## 2. Spark Streaming

We have multiple example and use cases with Spark Streaming.

|Sub Projects                                                                               |
| ----------------------------------------------------------------------------------------- |
|[spark-python](spark-python/README.md)                                |
|[spark-scala](spark-scala/README.md)                                  |

## 3. KStreams with Schema Registry
Can be viewed from KAFKA UI. More details to follow.
## 4. Kafka REST API
[List of Commands](kafka-rest/README.md)

## 5. Connect KStreams with Spark Streaming
We have multiple example and use cases with Spark Streaming.

|Sub Projects                                                                               |
| ----------------------------------------------------------------------------------------- |
|[spark-scala-enrich-topic](spark-scala-enrich-topic/README.md)        |
|[spark-scala-functions](spark-scala-functions/README.md)              |


## 6. Connect Spark Streaming with KStreams
|Sub Projects                                                                               |
| ----------------------------------------------------------------------------------------- |
|[spark-scala-enrich-topic](spark-scala-enrich-topic/README.md)        |
|[spark-scala-functions](spark-scala-functions/README.md)              |


## 7. KAFKA-UI
This [project](kafka-ui/README.md) is to help Kafka developers to manage there clusters with UI.
Using KAFKA-UI you can take advantage of all the maintenance and monitoring capabilities of Kafka using a click of a button.