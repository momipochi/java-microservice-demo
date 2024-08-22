# Use an official Maven image to build the application
FROM maven:3.9.9-eclipse-temurin-21 AS build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean test package

RUN apt-get update
RUN apt-get install -y curl 

# Use a minimal Java runtime image to run the application
FROM eclipse-temurin:21-jre-alpine


# Copy the packaged jar file from the build stage
COPY --from=build /home/app/target/*.jar eurekaserver.jar

# Expose the port your application runs on
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "eurekaserver.jar"]
