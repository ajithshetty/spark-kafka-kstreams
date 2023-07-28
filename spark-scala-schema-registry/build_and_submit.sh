mvn clean package
cp target/spark-scala-schema-registry-streaming-1.0-SNAPSHOT-jar-with-dependencies.jar apps/spark-scala-schema-registry-streaming-1.0-SNAPSHOT-jar-with-dependencies.jar
docker-compose exec spark-master sh /opt/spark-scala-schema-registry-apps/submit_job.sh