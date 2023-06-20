FROM openjdk:11
COPY target/webApp.jar /app.jar
EXPOSE 8086
CMD ["java", "-jar", "/app.jar"]