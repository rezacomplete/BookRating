FROM maven:3.5-jdk-8-alpine AS build
COPY . .
RUN mvn clean install

FROM openjdk:8-jre-alpine
COPY --from=build /target/*.jar bookRating.jar
ENTRYPOINT ["java","-jar","/bookRating.jar"]