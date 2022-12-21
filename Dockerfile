FROM openjdk:11

MAINTAINER Ghofran Abdelwahab <prog.ghofranabdelwahab@gmail.com>

COPY /var/jenkins_home/jenkins/workspace/braintuck/target/base-0.0.1-SNAPSHOT.jar base-app.jar

ENTRYPOINT ["java","-jar", "base-app.jar"]
