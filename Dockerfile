FROM openjdk:15

WORKDIR /app

#RUN mvn -N io.takari:maven:wrapper
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY src .

RUN ./mvnw package

COPY . .

CMD ["java", "-jar", "target/*.jar"]
