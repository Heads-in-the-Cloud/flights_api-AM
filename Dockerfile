FROM adoptopenjdk/openjdk11:alpine-jre
ARG JARFILE_NAME
COPY ./target/${JARFILE_NAME} /usr/app/utopia.jar
COPY ./src/main/resources /src/main/resources
ENTRYPOINT ["java", "-jar", "/usr/app/utopia.jar"]
