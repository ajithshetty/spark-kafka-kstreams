### Exercise Descriptions

Here's a brief description of each example in this repository.  For detailed step-by-step descriptions follow the Kafka Streams
course videos.  Note that for the purposes of facilitating the learning process, each exercise uses a utility class `TopicLoader` that will create
the required topics and populate them with some sample records for the Kafka Streams application. As a result when you run each exercise, the first output you'll
see on the console is from the `Callback` interface, and it will look similar to this:
```text
Record produced - offset - 56 timestamp - 1689974156214 
Record produced - offset - 57 timestamp - 1689974156228 
Record produced - offset - 58 timestamp - 1689974156228 
Record produced - offset - 59 timestamp - 1689974156228 
Record produced - offset - 60 timestamp - 1689974156228 
Record produced - offset - 61 timestamp - 1689974156228 
Record produced - offset - 62 timestamp - 1689974156228 
```

#### Basic Operations

The basic operations exercise demonstrates using Kafka Streams stateless operations like `filter` and `mapValues`.
You run the basic operations example with this command ` ./gradlew runStreams -Pargs=basic` and your output on the console should resemble this:
```text
Incoming record - key order-key value orderNumber-1001
Outgoing record - key order-key value 1001
Incoming record - key order-key value orderNumber-5000
Outgoing record - key order-key value 5000
Incoming record - key order-key value orderNumber-999
Incoming record - key order-key value orderNumber-3330
Outgoing record - key order-key value 3330
Incoming record - key order-key value bogus-1
Incoming record - key order-key value bogus-2
Incoming record - key order-key value orderNumber-8400
Outgoing record - key order-key value 8400
```
Take note that it's expected to not have a corresponding output record for each input record due to the filters applied by the Kafka Steams application.
