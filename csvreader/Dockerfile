# Use a Maven image that includes both Maven and OpenJDK
FROM maven:3.8.8-eclipse-temurin-17

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY . .

# Expose the Spring Boot port
EXPOSE 8080

# Run the application in development mode
CMD ["mvn", "spring-boot:run"]
