# Kafka UI

Please go through https://github.com/provectus/kafka-ui for more information.

##Details
This repo is to help Kafka developers to manage there clusters with UI.
Using KAFKA-UI you can take advantage of all the maintenance and monitoring capabilities of Kafka using a click of a button.

KAFKA-UI is comprises a lot of features:
1. Multi-Cluster Management — monitor and manage all your clusters in one place
2. Performance Monitoring with Metrics Dashboard — track key Kafka metrics with a lightweight dashboard
3. View Kafka Brokers — view topic and partition assignments, controller status
4. View Kafka Topics — view partition count, replication status, and custom configuration
5. View Consumer Groups — view per-partition parked offsets, combined and per-partition lag
6. Browse Messages — browse messages with JSON, plain text, and Avro encoding
7. Dynamic Topic Configuration — create and configure new topics with dynamic configuration
8. Configurable Authentication — secure your installation with optional Github/Gitlab/Google OAuth 2.0
9. Custom serialization/deserialization plugins - use a ready-to-go serde for your data like AWS Glue or Smile, or code your own!
10. Role based access control - manage permissions to access the UI with granular precision
11. Data masking - obfuscate sensitive data in topic messages.

## How to get started
1. Execute [start_container.sh](/Users/ajith.shetty/personal_project/spark-kafka-kstreams/start_containers.sh)
2. Hit the URL http://localhost:18080/

start_container.sh script comprises of all the necessary resources which are needed for KAFKA-UI to work.