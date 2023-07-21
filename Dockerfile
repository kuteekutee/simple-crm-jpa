FROM eclipse-temurin:17.0.7_7-jdk

WORKDIR /app

COPY target/simple-crm-jpa-0.0.1.jar crm-app.jar

CMD ["java", "-jar", "crm-app.jar"]