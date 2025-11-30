FROM openjdk:21-rc-oracle
COPY target/attestation03-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080