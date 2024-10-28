# Use a lightweight base image with OpenJDK
FROM openjdk:11-jre-slim
COPY target/work-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","work-0.0.1-SNAPSHOT.jar"]
