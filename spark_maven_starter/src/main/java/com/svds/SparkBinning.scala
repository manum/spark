/*
Author: Manu Mukerji <next2manu@gmail.com>

*/

package com.example


import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf


object SparkMaven {
    def main(args: Array[String]) {  
        //Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    
        val conf = new SparkConf()
        .setAppName("SparkMavenTest")
        .set("spark.executor.memory", "1g")
        val sc = new SparkContext(conf)

        val sqlContext = new org.apache.spark.sql.SQLContext(sc)
        val experian_data = sqlContext.parquetFile("/user/ubuntu/test_data")
        experian_data.registerAsTable("test_data")
        
        import sqlContext._
        sqlContext.sql("SELECT * FROM test_data").count()
    }
}
