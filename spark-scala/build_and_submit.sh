mvn clean package
cp target/structured-streaming-1.0-SNAPSHOT-jar-with-dependencies.jar apps/structured-streaming-1.0-SNAPSHOT-jar-with-dependencies.jar
docker-compose exec spark-master sh /opt/spark-scala-apps/submit_job.sh