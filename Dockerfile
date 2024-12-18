FROM openjdk:17-jdk

WORKDIR /app
COPY target/mongodb-0.0.1-SNAPSHOT.jar /app/mongodb.jar

EXPOSE 8080

CMD ["java", "-jar", "mongodb.jar"]
