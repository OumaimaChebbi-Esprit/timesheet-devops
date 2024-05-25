FROM openjdk:17-slim
EXPOSE 8082
ADD http://192.168.56.2:8081/repository/maven-releases/tn/esprit/spring/services/timesheet-devops/1.0/timesheet-devops-1.0.jar
ENTRYPOINT ["java", "-jar", "timesheet-devops-1.0.jar"]
