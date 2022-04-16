FROM openjdk:11
ADD target/cafe-api.jar cafe-api.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "cafe-api.jar"]