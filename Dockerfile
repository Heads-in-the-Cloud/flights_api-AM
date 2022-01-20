FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/utopia-0.0.1-SNAPSHOT.jar /usr/app/utopia.jar
COPY ./src/main/resources /src/main/resources
ENTRYPOINT ["java", "-jar", "/usr/app/utopia.jar"]
