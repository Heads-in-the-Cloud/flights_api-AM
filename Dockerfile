FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/${jar_name} /usr/app/${jar_name}
COPY ./src/main/resources /src/main/resources
ENTRYPOINT ["java", "-jar", "/usr/app/${jar_name}"]
