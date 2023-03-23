FROM amazoncorretto:17

EXPOSE 9090

COPY target/*.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "java-backend-9.0-jar-with-dependencies.jar"]
