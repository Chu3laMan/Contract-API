FROM openjdk:11-jdk-slim

WORKDIR /app

COPY ./target/contractapp-1.0-SNAPSHOT.jar /app/contract.jar

EXPOSE 9090

ENV JAVA_OPTS=""

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/contract.jar"]
