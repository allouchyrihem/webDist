FROM openjdk:17
EXPOSE 8082
ADD target/Pack_MService-0.0.1-SNAPSHOT.jar-0.0.1 package.jar
ENTRYPOINT ["java","-jar","package.jar"]