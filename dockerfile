# Use a lightweight OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-alpine as build

# Set work directory inside the container
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build the project
RUN ./mvnw clean package -DskipTests

# Use a slim runtime image for final container
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/task-manager-app.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
