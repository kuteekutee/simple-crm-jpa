FROM openjdk:17

WORKDIR /app

COPY target/simple-crm-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "simple-crm-0.0.1-SNAPSHOT.jar"]