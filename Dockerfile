# Step 1: Build the application
FROM maven:3.8.4-amazoncorretto-17 AS build
WORKDIR /app
COPY . .
# This command tells Maven to skip compiling AND running tests
RUN mvn clean package -Dmaven.test.skip=true

# Step 2: Run the application
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]