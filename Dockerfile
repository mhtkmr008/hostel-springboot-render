FROM maven:3.8.4-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:11.0-jdk-slim
COPY --from=build /app/target/spring_boot_backend_template-0.0.1.jar spring_boot_backend_template.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring_boot_backend_template.jar"]
