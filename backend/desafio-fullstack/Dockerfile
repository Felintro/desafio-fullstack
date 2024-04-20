FROM maven:3.8.5-openjdk-17 AS build
RUN mkdir -p /app
WORKDIR /app
ADD . /app
RUN mvn package

FROM eclipse-temurin:17-jdk
RUN mkdir -p /app
WORKDIR /app
COPY --from=build /app/target/app.war app.war
EXPOSE 8082
CMD ["java", "-jar", "app.war"]