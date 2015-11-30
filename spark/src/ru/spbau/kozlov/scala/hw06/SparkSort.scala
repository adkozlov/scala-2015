package ru.spbau.kozlov.scala.hw06

import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author adkozlov
  */
object SparkSort {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("sort")
      .setMaster("local")
      .set("spark.local.dir", args(2))
    val context = new SparkContext(conf)
    context.textFile(args(0))
      .persist(StorageLevel.MEMORY_AND_DISK)
      .map(line => (line, 0))
      .sortBy(_._1)
      .map(_._1)
      .coalesce(1)
      .saveAsTextFile(args(1))
  }
}
