FROM adoptopenjdk/openjdk17:jre-17.0.1_12-alpine

EXPOSE 8080

COPY target/*.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "java-backend-7.0-jar-with-dependencies.jar"]
