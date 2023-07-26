FROM eclipse-temurin:8-jre
COPY target/simple-http-server-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]