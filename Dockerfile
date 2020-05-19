FROM java:8
EXPOSE 8080
ADD target/lms-maven-docker.jar lms-maven-docker.jar
ENTRYPOINT ["java" ,"-jar","lms-maven-docker.jar"]