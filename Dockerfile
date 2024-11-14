# Start with a base image with OpenJDK
FROM openjdk:17-jdk-slim

# Set a working directory inside the container
WORKDIR /app

# Copy your JAR file into the container (adjust if using Maven or Gradle)
COPY target/api-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Expose the port your app will run on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "myapp.jar"]
