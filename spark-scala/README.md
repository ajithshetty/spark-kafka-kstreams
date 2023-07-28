# Kafka Streams > Spark Streaming

This Project is mainly focused on how we can integrate Kafka Streams with Scala Spark Streaming.

We will be using the Bank transaction as our example.

The Goals are as follows:
1. Generate the data for the given topic
2. Using Kafka Streams push the data to a topic
3. Spark Structured Streaming will read the topic and write to S3

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

`./gradlew runStreams -Pargs=`[basic](src/main/java/io/confluent/developer/basic/README.md)


Each execution of `runStreams` will build the project first.  Each streams application will continue to run after you have started it, so once you are done
enter a `CTRL+C` from the keyboard to shut it down.

## 2. Spark Streaming
We need to copy the avro file for our example BANK:

Update the topic names and spark properties:
#### spark-scala/src/main/resources/input.properties


Under the project path: `spark-scala`

Run the below scripts:

`sh build.sh`  To build the Fat Jar

`sh submit.sh`  To submit the job under the Spark Container


## Output
To Be Updated..................