pipeline {
    agent any
    tools  {
        maven 'M2_HOME'
    }
    stages {
        stage ('GIT') {
            steps {
                git branch: 'master',
                url : 'https://github.com/OumaimaChebbi-Esprit/timesheet-devops.git'
            }
        }
        stage ('MVN CLEAN') {
            steps {
                sh 'mvn clean';
            }
        }
        stage ('MVN COMPILE') {
            steps {
                sh 'mvn compile';
            }
        }
        stage ('SONAR QUBE') {
            steps {
                echo 'Sonar Qube'
                // sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
            }
        }
    }
}pipeline {
     agent any
     tools  {
         maven 'M2_HOME'
     }
     stages {
         stage ('GIT') {
             steps {
                 git branch: 'master',
                 url : 'https://github.com/OumaimaChebbi-Esprit/timesheet-devops.git'
             }
         }
         stage ('MVN CLEAN') {
             steps {
                 sh 'mvn clean';
             }
         }
         stage ('MVN COMPILE') {
             steps {
                 sh 'mvn compile';
             }
         }
         stage ('SONAR QUBE') {
             steps {
                 echo 'Sonar Qube'
                 // sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dmaven.test.skip=true';
             }
         }
     }
 }