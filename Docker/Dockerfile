FROM openjdk:8-jdk-alpine

ADD target/weather-app0.0.1-SNAPSHOT.jar app.jar

EXPOSE 80800

ENTRYPOINT["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]