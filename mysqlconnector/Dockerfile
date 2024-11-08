# Use an OpenJDK image with Maven wrapper and Java SDK
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the Maven Wrapper and project files
COPY . .

# Ensure the Maven Wrapper is executable
RUN chmod +x ./mvnw

# Expose the application port
EXPOSE 8080

# Run the Spring Boot application using the Maven Wrapper
CMD ["./mvnw", "spring-boot:run"]
