FROM openjdk:11
WORKDIR /app
COPY veiculos-0.0.1-SNAPSHOT.jar /app
CMD ["java", "-jar", "/app/veiculos-0.0.1-SNAPSHOT.jar"]
EXPOSE 8089