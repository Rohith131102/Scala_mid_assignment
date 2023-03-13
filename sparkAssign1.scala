package spark

import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.functions._
//import org.apache.spark.sql.execution.streaming.MemoryStreamTableProvider.inferSchema
//import org.json4s.scalap.scalasig.ClassFileParser.header

object SparkAssign {

  def main(args: Array[String]) {
    val spark = SparkSession.builder ().master ("local[2]").appName ("Spark Assignment-1").getOrCreate ()
    val sc = spark.sparkContext

    val df = spark.read
    .option ("header", "false")
    .option ("inferSchema", "true")
    .csv ("/Users/rohith_boodireddy/Downloads/cust_data.csv")

    val transformedDf = df.groupBy("_c0").sum("_c2").sort("_c0").collect()


    transformedDf.foreach (println(_))

    Thread.sleep(40000)

  }
}