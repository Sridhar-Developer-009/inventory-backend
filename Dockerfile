# Step 1: Build the application using Maven and Amazon Corretto 17
FROM maven:3.8.4-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run the application using Amazon Corretto 17 (More reliable)
FROM amazoncorretto:17-alpine
WORKDIR /app
# We use a wildcard to find the jar since the name might vary slightly
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]