import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.streaming.Trigger.ProcessingTime

import java.util.Properties
import scala.collection.mutable

object ProcessData extends App {

  val properties = new Properties
  properties.load(this.getClass.getResourceAsStream("/input.properties"))

  val sparkSession = SparkSession.builder()
    .appName(properties.getProperty("app_name"))
    .config("spark.sql.shuffle.partitions", 2)
    .getOrCreate()

  sparkSession.conf.set("fs.s3a.endpoint", properties.getProperty("s3_url"))
  sparkSession.conf.set("fs.s3a.access.key", properties.getProperty("s3_access_key"))
  sparkSession.conf.set("fs.s3a.secret.key", properties.getProperty("s3_secret_key"))
  sparkSession.conf.set("fs.s3a.path.style.access", "true")
  sparkSession.conf.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")


  val inputKafkaRecords = sparkSession.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", properties.getProperty("kafka_server"))
    .option("subscribe", properties.getProperty("kafka_topic"))
    .option("startingOffsets", properties.getProperty("kafka_offset"))
    .option("failOnDataLoss", "false")
    .load()


  val writeQuery = inputKafkaRecords
    .select(col("key").cast("string"), col("value").cast("string"), col("timestamp").cast("string"))
    .writeStream
    .format("console")
    .format(properties.getProperty("destination_format"))
    .trigger(ProcessingTime("20 seconds"))
  .option("path", s"s3a://${properties.getProperty("base_bucket")}landing-scala/")
  .option("checkpointLocation", s"s3a://${properties.getProperty("base_bucket")}checkpoint/")

  writeQuery.start().awaitTermination()

}