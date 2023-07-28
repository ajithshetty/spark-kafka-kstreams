import org.apache.spark.sql.avro.functions.from_avro
import org.apache.spark.sql.{SparkSession, functions}

import java.util.Properties

object EnrichTopic extends App {
try {

  val properties = new Properties
  properties.load(this.getClass.getResourceAsStream("/input.properties"))

  val sparkSession = SparkSession.builder()
    .appName(properties.getProperty("app_name"))
    .config("spark.sql.shuffle.partitions", 2)
    .getOrCreate()

  import sparkSession.implicits._

  sparkSession.conf.set("fs.s3a.endpoint", properties.getProperty("s3_url"))
  sparkSession.conf.set("fs.s3a.access.key", properties.getProperty("s3_access_key"))
  sparkSession.conf.set("fs.s3a.secret.key", properties.getProperty("s3_secret_key"))
  sparkSession.conf.set("fs.s3a.path.style.access", "true")
  sparkSession.conf.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")


  val inputKafkaRecords = sparkSession.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", properties.getProperty("kafka_server"))
    .option("subscribe", properties.getProperty("kafka_input_topic"))
    .option("startingOffsets", properties.getProperty("kafka_offset"))
    .option("failOnDataLoss", "false")
    .load()


  /* Use it for sampling.

  writeQueryParsed
    .writeStream
    //.outputMode("complete")
    .format("console")
    .option("checkpointLocation", s"s3a://${config("base_bucket")}checkpoint-rejected-enrich/")
    .start().awaitTermination()
    */

  val jsonFormatSchema = new String(this.getClass.getResourceAsStream("/bank.avsc").readAllBytes())

  val writeQueryParsed = inputKafkaRecords
    //https://stackoverflow.com/questions/48882723/integrating-spark-structured-streaming-with-the-confluent-schema-registry
    //Skip the first 5 bytes (reserved by schema registry encoding protocol)
    //https://docs.confluent.io/platform/current/schema-registry/fundamentals/serdes-develop/index.html#wire-format
    .selectExpr("substring(value, 6) as avro_value")
    .select("avro_value")
    .select(from_avro($"avro_value", jsonFormatSchema).as("bank"))
    .select("bank.*")
    .groupBy("account_id")
    //https://spark.apache.org/docs/latest/structured-streaming-kafka-integration.html#writing-data-to-kafka
    //key (optional)	string or binary
    //value (required)	string or binary
    .agg(functions.sum("withdraw").as("value"))
    .withColumnRenamed("account_id","key")


  writeQueryParsed
  .select(writeQueryParsed("key").cast("string"), writeQueryParsed("value").cast("string"))
    .writeStream
    .outputMode("complete")
    .format("kafka")
    .option("kafka.bootstrap.servers", properties.getProperty("kafka_server"))
    .option("topic", properties.getProperty("kafka_output_topic"))
    .option("checkpointLocation", s"s3a://${properties.getProperty("base_bucket")}/checkpoint-rejected-enrich-topic/")
    .start()
    .awaitTermination()
}catch {
  case e: Exception =>
      println(e.getMessage)
    throw new RuntimeException(e)
}

}