FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /tarefa13

COPY gradlew gradlew.bat settings.gradle ./
COPY gradle ./gradle
COPY build.gradle ./

RUN ./gradlew dependencies --no-daemon

COPY src ./src

RUN ./gradlew clean build --no-daemon

# Runtime
FROM eclipse-temurin:21-jre-alpine

WORKDIR /tarefa13

COPY --from=build /tarefa13/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
