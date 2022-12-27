FROM openjdk:17-jdk-slim
COPY target/transfer-0.0.1-SNAPSHOT.jar transfer-0.0.1.jar
ENTRYPOINT ["java","-jar","/transfer-0.0.1.jar"]