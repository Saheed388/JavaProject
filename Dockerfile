# Use an OpenJDK base image
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file to the working directory
COPY target/*.jar app.jar

# Expose the application's port (e.g., 8080)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
