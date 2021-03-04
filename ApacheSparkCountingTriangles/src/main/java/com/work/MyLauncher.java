package com.work;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

/**
 *  http://spark.apache.org/docs/latest/api/java/index.html?org/apache/spark/launcher/package-summary.html
 *  Установка SPARK
 *  https://www.tutorialspoint.com/apache_spark/apache_spark_installation.htm
 */
public class MyLauncher {
    public static void main(String[] args) throws Exception {
        SparkAppHandle handle = new SparkLauncher()
                .setAppResource("target/ApacheSparkCountingTriangles-1.0-SNAPSHOT.jar")
                .setMainClass("com.work.SparkApplication")
                .setMaster("local")
                .setConf(SparkLauncher.DRIVER_MEMORY, "2g")
                .startApplication();
        // Use handle API to monitor / control application.
    }
}
