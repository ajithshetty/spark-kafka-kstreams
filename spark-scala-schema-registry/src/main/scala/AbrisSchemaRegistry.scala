import org.apache.spark.sql.SparkSession
import scala.collection.mutable

object AbrisSchemaRegistry extends App {


  var config = mutable.HashMap(
    "app_name"->"streaming",
    "destination_format"->"json",
    "s3_url"->"http://minio:9000",
    "s3_access_key"->"minioadmin",
    "s3_secret_key"->"minioadmin",
    "base_bucket"->"kafka-topic-data/",
    "kafka_server"->"broker:29092",
    "kafka_client_id"->"aggregating-count-app1c",
    "kafka_topic"->"bank.output.topic",
    "kafka_offset"->"earliest",
    "kafka_registry_url"->"http://localhost:8081")

  val sparkSession = SparkSession.builder()
    .appName("ABRiS demo")
    .config("spark.sql.shuffle.partitions", 2)
    .getOrCreate()

  import sparkSession.implicits._

  val inputKafkaRecords = sparkSession.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", config("kafka_server"))
    .option("client.id", config("kafka_client_id"))
    .option("subscribe", config("kafka_topic"))
    .option("startingOffsets", config("kafka_offset"))
    .load()

  /*val avroOrders = inputKafkaRecords
    .select(from_avro($"value", AbrisConfig
      .fromConfluentAvro
      .downloadReaderSchemaByLatestVersion
      .andTopicNameStrategy(config("kafka_topic"))
      .usingSchemaRegistry(config("kafka_registry_url"))).as("bank"))
    .selectExpr("bank", "bank.*")

  val writeQuery = avroOrders
    .writeStream
    .format("console")
    .option("truncate", false)

  writeQuery.start().awaitTermination()*/

}