FROM adoptopenjdk/openjdk11:alpine-jre
#FROM openjdk:12
ADD target/customer-api-0.0.1-SNAPSHOT.jar customer-api.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","customer-api.jar"]
#CMD ["java","-jar","customer-api.jar"]

#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar

#ENTRYPOINT ["java", "-jar", "application.jar"]