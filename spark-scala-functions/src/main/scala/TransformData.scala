import org.apache.spark.sql.avro.functions.from_avro
import org.apache.spark.sql.functions.{col, typedLit, when}
import org.apache.spark.sql.{Dataset, Row, SparkSession}

import java.util.Properties

object TransformData extends App {
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

    val inputKafkaRecords = sparkSession
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", properties.getProperty("kafka_server"))
      .option("subscribe", properties.getProperty("kafka_topic"))
      .option("startingOffsets", properties.getProperty("kafka_offset"))
      .option("failOnDataLoss", "false")
      .load()


    val jsonFormatSchema = new String(this.getClass.getResourceAsStream("/transcations.avsc").readAllBytes())

    val parsedTransactions=inputKafkaRecords
      .selectExpr("substring(value, 6) as avro_value")
      .select("avro_value")
      .select(from_avro($"avro_value", jsonFormatSchema).as("transactions"))
      .select("transactions.*")


    // Streaming doesnt support pivot.
    // So we had to use the for each function to write to console
    def transformDF = (df: Dataset[Row], batchId: Long) => {
      df.withColumn("job_level",
        when(col("job_level").isNull||col("job_level")=="",typedLit(0L))
          .otherwise(col("job_level")))
        .groupBy("transaction_id","time","created_by","created_date")
        .pivot("job_level")
        .count()
        .na.fill(0)
        .show(false)
    }

    val startedParsedDF=parsedTransactions
      .writeStream
      .foreachBatch(transformDF)
      .start()


    startedParsedDF.awaitTermination()
  }catch {
    case e: Exception =>
      println(e.getMessage)
      throw new RuntimeException(e)
  }

}