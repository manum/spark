To run use the following

1) Create JAR by running mvn install 

2) scp JAR to server

3) Use spark-submit to send job

	spark-submit --class com.example.SparkMaven --master spark://spark-master:7077  /tmp/spark_maven-1.0-SNAPSHOT.jar


