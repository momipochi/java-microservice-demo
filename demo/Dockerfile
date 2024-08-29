# Use an official Maven image to build the application
FROM gradle:8.10.0-jdk21 AS build

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

# Use a minimal Java runtime image to run the application
FROM eclipse-temurin:21-jre-alpine

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
# Expose the port your application runs on
EXPOSE 8081

ENTRYPOINT ["java", "-jar","/app/spring-boot-application.jar"]
