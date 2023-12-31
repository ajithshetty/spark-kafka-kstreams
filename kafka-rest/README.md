### Get the local cluster information

```shell
curl http://localhost:8082/v3/clusters
```
```json
{"kind":"KafkaClusterList",
  "metadata":{"self":"http://rest-proxy:8082/v3/clusters","next":null},
  "data":[{"kind":"KafkaCluster",
    "metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw",
      "resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw"},
    "cluster_id":"9dt-RWAfRLyOMdg92y6Syw",
    "controller":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/brokers/1"},
    "acls":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/acls"},"brokers":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/brokers"},"broker_configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/broker-configs"},
    "consumer_groups":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/consumer-groups"},
    "topics":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics"},
    "partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/-/partitions/-/reassignment"}}]}
```

```shell
curl http://localhost:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics
```
```json
{"kind":"KafkaTopicList","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics","next":null},"data":[{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_confluent-ksql-default__command_topic","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=_confluent-ksql-default__command_topic"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"_confluent-ksql-default__command_topic","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_confluent-ksql-default__command_topic/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_confluent-ksql-default__command_topic/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_confluent-ksql-default__command_topic/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_schemas","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=_schemas"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"_schemas","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_schemas/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_schemas/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/_schemas/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-aggregated-streams11","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=bank-spark-aggregated-streams11"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"bank-spark-aggregated-streams11","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-aggregated-streams11/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-aggregated-streams11/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-aggregated-streams11/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-analysis-streams11","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=bank-spark-analysis-streams11"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"bank-spark-analysis-streams11","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-analysis-streams11/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-analysis-streams11/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-analysis-streams11/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-approved-streams11","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=bank-spark-approved-streams11"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"bank-spark-approved-streams11","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-approved-streams11/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-approved-streams11/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-approved-streams11/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-input-streams11","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=bank-spark-input-streams11"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"bank-spark-input-streams11","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-input-streams11/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-input-streams11/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-input-streams11/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-rejected-streams11","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=bank-spark-rejected-streams11"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"bank-spark-rejected-streams11","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-rejected-streams11/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-rejected-streams11/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/bank-spark-rejected-streams11/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/default_ksql_processing_log","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=default_ksql_processing_log"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"default_ksql_processing_log","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/default_ksql_processing_log/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/default_ksql_processing_log/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/default_ksql_processing_log/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-configs","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=docker-connect-configs"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"docker-connect-configs","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-configs/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-configs/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-configs/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-offsets","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=docker-connect-offsets"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"docker-connect-offsets","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-offsets/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-offsets/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-offsets/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-status","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=docker-connect-status"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"docker-connect-status","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-status/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-status/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/docker-connect-status/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=example-topic"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"example-topic","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/jsontest","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=jsontest"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"jsontest","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/jsontest/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/jsontest/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/jsontest/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-input","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=transactions-input"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"transactions-input","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-input/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-input/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-input/partitions/-/reassignment"}},{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-output","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=transactions-output"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"transactions-output","is_internal":false,"replication_factor":1,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-output/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-output/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/transactions-output/partitions/-/reassignment"}}]}
```

### Create a topic

```shell
curl -X POST -H "Content-Type:application/json" -d '{"topic_name":"example-topic"}' http://localhost:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics
```

```json
{"kind":"KafkaTopic","metadata":{"self":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic","resource_name":"crn:///kafka=9dt-RWAfRLyOMdg92y6Syw/topic=example-topic"},"cluster_id":"9dt-RWAfRLyOMdg92y6Syw","topic_name":"example-topic","is_internal":false,"replication_factor":0,"partitions":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/partitions"},"configs":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/configs"},"partition_reassignments":{"related":"http://rest-proxy:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/partitions/-/reassignment"}}
```

### Produce records with JSON data

```shell
curl -X POST -H "Content-Type: application/json" \
-d '{"value":{"type":"STRING","data":"12345"}}' \
http://localhost:8082/v3/clusters/9dt-RWAfRLyOMdg92y6Syw/topics/example-topic/records
```


### Get a list of topics

```shell
curl http://localhost:8082/topics
```
```json
["docker-connect-status","_confluent-ksql-default__command_topic","default_ksql_processing_log","docker-connect-configs","example-topic","_schemas","bank-spark-aggregated-streams11","transactions-output","bank-spark-input-streams11","bank-spark-approved-streams11","bank-spark-analysis-streams11","bank-spark-rejected-streams11","transactions-input","docker-connect-offsets"]
```

### Produce records with JSON data
```shell
curl -X POST -H "Content-Type: application/vnd.kafka.json.v2+json" \
-d '{"records":[{"value":{"name": "user_123"}}]}' http://localhost:8082/topics/example-topic
```
```json
{"offsets":[{"partition":0,"offset":0,"error_code":null,"error":null}],"key_schema_id":null,"value_schema_id":null}
```  

### Consume JSON data
```shell
curl -X POST -H "Content-Type: application/vnd.kafka.v2+json" -H \
"Accept: application/vnd.kafka.v2+json" \
-d '{"name": "my_consumer_instance", "format": "json", "auto.offset.reset": "earliest"}' \
http://localhost:8082/consumers/test_consumer
```

```json
{"instance_id":"my_consumer_instance","base_uri":"http://rest-proxy:8082/consumers/test_consumer/instances/my_consumer_instance"}
````

### Subscribe the consumer to a topic.

```shell
curl -X POST -H "Content-Type: application/vnd.kafka.v2+json" \
-d '{"topics":["example-topic"]}' \
http://localhost:8082/consumers/test_consumer/instances/my_consumer_instance/subscription
```

### consume some data
```shell
curl -X GET -H "Accept: application/vnd.kafka.json.v2+json" \
http://localhost:8082/consumers/test_consumer/instances/my_consumer_instance/records
```
```json
[{"topic":"example-topic","key":null,"value":{"name":"user_123"},"partition":0,"offset":0}]
```

### Close the consumer with a DELETE to make it leave the group and clean up its resources.
```shell
curl -X DELETE -H "Accept: application/vnd.kafka.v2+json" \
http://localhost:8082/consumers/test_consumer/instances/my_consumer_instance
```
