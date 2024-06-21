
FROM amazoncorretto:21-alpine3.17-jdk

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY target/record-shop-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
