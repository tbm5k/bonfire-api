FROM openjdk:15

WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY src .

RUN ./mvnw package

CMD ["java", "-jar", "target/*.jar"]