This is the code repo containing the full solutions to the exercises
for the Kafka Streams course.

It's recommended to watch the [Basic Operations lecture](https://developer.confluent.io/learn-kafka/kafka-streams/basic-operations/) and the [Hands On: Basic Operations](https://developer.confluent.io/learn-kafka/kafka-streams/hands-on-basic-operations/) videos first.

Follow the steps below to get everything ready to go.

### Setting up properties for running the exercise code
For easy setup we have the fully ready docker-compose.yaml file which will bring up the necessary containers.

We have all the default configurations defined in a file:

`src/main/resources/streams.properties`

### Running the exercises

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

`./gradlew runStreams -Pargs=<application>`

where `<application>` is one of

|COMMANDS(links) |
| ------- |
|[basic](src/main/java/io/confluent/developer/basic/README.md)        |
|[banksparkwrite](src/main/java/io/confluent/developer/bankspark/README.md)        |
|[banksparkread](src/main/java/io/confluent/developer/bankspark/README.md)        |


Each execution of `runStreams` will build the project first.  Each streams application will continue to run after you have started it, so once you are done
enter a `CTRL+C` from the keyboard to shut it down.
