# Use the official OpenJDK base image
FROM eclipse-temurin:17-jdk-alpine

# Copy the JAR file into the container
COPY target/*.jar filght-status-service-1.0.0.jar

# Expose the port your application will run on
EXPOSE 8080

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "/filght-status-service-1.0.0.jar"]
