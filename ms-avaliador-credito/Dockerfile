FROM maven:3.8.5-openjdk-11 as build
WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
ARG RABBITMQ_SERVER=rabbitmq-host
ARG EUREKA_SERVER=localhost
COPY --from=build ./app/target/*.jar ./app.jar
ENTRYPOINT java -jar app.jar