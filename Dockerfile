FROM openjdk:11

MAINTAINER Ghofran Abdelwahab <prog.ghofranabdelwahab@gmail.com>

ARG PATH

COPY $PATH/target/base-0.0.1-SNAPSHOT.jar base-app.jar

ENTRYPOINT ["java","-jar", "base-app.jar"]
