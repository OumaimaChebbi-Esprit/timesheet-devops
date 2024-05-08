FROM openjdk:8-jre-slim
WORKDIR /app
RUN apt-get update && apt-get install -y curl && curl -u admin:nexus -O http://192.168.56.2:8081/repository/maven-releases/tn/esprit/spring/services/timesheet-devops/1.0/timesheet-devops-1.0.jar
RUN apt-get remove -y curl && apt-get clean
EXPOSE 8083
CMD ["java", "-jar", "timesheet-devops-1.0.jar"]