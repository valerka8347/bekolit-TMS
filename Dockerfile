FROM openjdk:11
COPY /target/*.jar/app.jar
ENTPYPOINT ["java", "-jar", "/app.jar"]



