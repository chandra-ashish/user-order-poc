# Build a JAR File
FROM maven:3.6.3-jdk-8-slim AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

# Create an Image
FROM openjdk:8-jdk-alpine
EXPOSE 8084
COPY --from=stage1 /home/app/target/user-order-poc-1.0.jar /user-order-poc-1.0.jar
CMD ["java", "-jar", "/user-order-poc-1.0.jar"]
