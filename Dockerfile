# Build stage
FROM maven:3.8.7 AS build

COPY . /home/maven/src
WORKDIR /home/maven/src
RUN mvn clean package -DskipTests

# Deploy stage
FROM openjdk:17-jdk-alpine

ENV APP_NAME="bike-rental"
COPY --from=build /home/maven/src/target/${APP_NAME}*.jar bike-rental.jar
ENTRYPOINT java -jar /bike-rental.jar
