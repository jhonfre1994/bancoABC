FROM openjdk:8-jdk
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8093
ENTRYPOINT ["java","-jar","/app/app.jar"]