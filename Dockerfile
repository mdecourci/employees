FROM openjdk:11

RUN mkdir -p /opt/app

ENV PROJECT_HOME /opt/app

COPY target/employees-1.0-SNAPSHOT.jar $PROJECT_HOME/employees.jar

EXPOSE 8080

WORKDIR $PROJECT_HOME

#ENTRYPOINT ["java", "-jar", "employees.jar"]
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=default", "./employees.jar"]