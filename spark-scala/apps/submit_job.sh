sh /opt/spark/bin/spark-submit --master spark://spark-master:7077 --total-executor-cores 1 --executor-memory 512M --jars $(echo /opt/airflow/jars/*.jar | tr ' ' ',') --class ProcessData /opt/spark-scala-apps/structured-streaming-1.0-SNAPSHOT-jar-with-dependencies.jar