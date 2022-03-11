#build stage
FROM maven:3.8.4-jdk-11-slim AS build

WORKDIR /app

COPY src /app/src
COPY pom.xml /app/

RUN mvn -f /app/pom.xml clean -DskipTests package

#package stage
FROM openjdk:15

COPY --from=build /app/target/*.jar backend.jar

CMD ["java", "-jar", "backend.jar"]
