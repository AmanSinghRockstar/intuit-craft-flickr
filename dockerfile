FROM openjdk:11.0.11-jre-slim
COPY /target/flickr.api-0.0.1-SNAPSHOT.jar /flickr-api/
WORKDIR /flickr-api
ENV PORT=8080
ENTRYPOINT ["java", "-jar", "flickr.api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080