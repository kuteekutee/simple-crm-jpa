FROM openjdk:17.0.7

WORKDIR /app

COPY target/simple-crm-0.0.1.jar crm-app.jar

CMD ["java", "-jar", "crm-app.jar"]