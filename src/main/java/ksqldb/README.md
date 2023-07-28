#### docker-compose exec ksqldb-cli ksql http://ksqldb-server.8088
OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.

                  ===========================================
                  =       _              _ ____  ____       =
                  =      | | _____  __ _| |  _ \| __ )      =
                  =      | |/ / __|/ _` | | | | |  _ \      =
                  =      |   <\__ \ (_| | | |_| | |_) |     =
                  =      |_|\_\___/\__, |_|____/|____/      =
                  =                   |_|                   =
                  =  Event Streaming Database purpose-built =
                  =        for stream processing apps       =
                  ===========================================

Copyright 2017-2020 Confluent Inc.

CLI v6.1.1, Server v<unknown> located at http://ksqldb-server.8088:80
Server Status: <unknown>

Having trouble? Type 'help' (case-insensitive) for a rundown of how things work!

no null host accepted
ajith.shetty@MPT-02368 learn-kafka-courses % docker-compose exec ksqldb-cli ksql http://ksqldb-server:8088
OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.

                  ===========================================
                  =       _              _ ____  ____       =
                  =      | | _____  __ _| |  _ \| __ )      =
                  =      | |/ / __|/ _` | | | | |  _ \      =
                  =      |   <\__ \ (_| | | |_| | |_) |     =
                  =      |_|\_\___/\__, |_|____/|____/      =
                  =                   |_|                   =
                  =  Event Streaming Database purpose-built =
                  =        for stream processing apps       =
                  ===========================================

Copyright 2017-2020 Confluent Inc.

CLI v6.1.1, Server v6.1.1 located at http://ksqldb-server:8088
Server Status: RUNNING

Having trouble? Type 'help' (case-insensitive) for a rundown of how things work!

ksql> exit;
Exiting ksqlDB.

ajith.shetty@MPT-02368 learn-kafka-courses % ls                                                                                                      
Dockerfile              backup                  build                   docker-compose.yml      gradlew                 logs                    spark                   start_containers.sh
README.md               buckets                 build.gradle            gradle                  gradlew.bat             settings.gradle         src
ajith.shetty@MPT-02368 learn-kafka-courses % docker-compose exec ksqldb-cli ksql http://ksqldb-server:8088
OpenJDK 64-Bit Server VM warning: Option UseConcMarkSweepGC was deprecated in version 9.0 and will likely be removed in a future release.

                  ===========================================
                  =       _              _ ____  ____       =
                  =      | | _____  __ _| |  _ \| __ )      =
                  =      | |/ / __|/ _` | | | | |  _ \      =
                  =      |   <\__ \ (_| | | |_| | |_) |     =
                  =      |_|\_\___/\__, |_|____/|____/      =
                  =                   |_|                   =
                  =  Event Streaming Database purpose-built =
                  =        for stream processing apps       =
                  ===========================================

Copyright 2017-2020 Confluent Inc.

CLI v6.1.1, Server v6.1.1 located at http://ksqldb-server:8088
Server Status: RUNNING

Having trouble? Type 'help' (case-insensitive) for a rundown of how things work!

ksql> show topics;

Kafka Topic                                                                 | Partitions | Partition Replicas
---------------------------------------------------------------------------------------------------------------
aggregating-count-app-KSTREAM-AGGREGATE-STATE-STORE-0000000004-changelog    | 1          | 1                  
aggregating-count-app-KSTREAM-AGGREGATE-STATE-STORE-0000000004-repartition  | 1          | 1                  
aggregating-count-app1-KSTREAM-AGGREGATE-STATE-STORE-0000000007-changelog   | 1          | 1                  
aggregating-count-app1-KSTREAM-AGGREGATE-STATE-STORE-0000000007-repartition | 1          | 1                  
aggregating-count-app1-KSTREAM-AGGREGATE-STATE-STORE-0000000012-changelog   | 1          | 1                  
aggregating-count-app1-KSTREAM-AGGREGATE-STATE-STORE-0000000012-repartition | 1          | 1                  
aggregating-count-app3-KSTREAM-AGGREGATE-STATE-STORE-0000000003-changelog   | 1          | 1                  
aggregating-count-app3-KSTREAM-AGGREGATE-STATE-STORE-0000000003-repartition | 1          | 1                  
aggregating-count-app4-KSTREAM-AGGREGATE-STATE-STORE-0000000003-changelog   | 1          | 1                  
aggregating-count-app4-KSTREAM-AGGREGATE-STATE-STORE-0000000003-repartition | 1          | 1                  
aggregating-count-app5-KSTREAM-AGGREGATE-STATE-STORE-0000000003-changelog   | 1          | 1                  
aggregating-count-app5-KSTREAM-AGGREGATE-STATE-STORE-0000000003-repartition | 1          | 1                  
aggregating-count-app6-KSTREAM-AGGREGATE-STATE-STORE-0000000003-changelog   | 1          | 1                  
aggregating-count-app6-KSTREAM-AGGREGATE-STATE-STORE-0000000003-repartition | 1          | 1                  
aggregating-count-app6-KSTREAM-AGGREGATE-STATE-STORE-0000000004-changelog   | 1          | 1                  
aggregating-count-app6-KSTREAM-AGGREGATE-STATE-STORE-0000000004-repartition | 1          | 1                  
aggregating-count-app8-KSTREAM-AGGREGATE-STATE-STORE-0000000004-changelog   | 1          | 1                  
aggregating-count-app8-KSTREAM-AGGREGATE-STATE-STORE-0000000004-repartition | 1          | 1                  
basic-input-streams                                                         | 1          | 1                  
basic-input-streams1                                                        | 1          | 1                  
basic-input-streams2                                                        | 1          | 1                  
basic-input-streams6                                                        | 1          | 1                  
basic-input-streams9                                                        | 1          | 1                  
basic-output-streams                                                        | 1          | 1                  
basic-output-streams1                                                       | 1          | 1                  
basic-output-streams9                                                       | 1          | 1                  
default_ksql_processing_log                                                 | 1          | 1                  
docker-connect-configs                                                      | 1          | 1                  
docker-connect-offsets                                                      | 25         | 1                  
docker-connect-status                                                       | 5          | 1
---------------------------------------------------------------------------------------------------------------
