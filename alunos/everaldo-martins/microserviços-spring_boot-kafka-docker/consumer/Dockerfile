FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY build/libs/consumer-1.0.0.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]