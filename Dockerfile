FROM openjdk:8-jre-alpine
COPY target/simple-http-server-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]