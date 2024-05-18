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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar';
            }
        }
        stage ('MOCKITO') {
            steps {
                sh 'mvn test -DskipTests'
            }
        }
        stage ('NEXUS') {
            steps {
                sh 'mvn deploy'
            }
        }
        stage('DOCKER IMAGES') {
            steps {
                sh 'docker build -t timesheetimage:v${BUILD_NUMBER} -f Dockerfile ./'
            }
        }
        stage ('DOCKER HUB') {
           steps {
               sh 'docker login -u oumaimaadmin -p docker123'
               sh 'docker tag timesheetimage:v${BUILD_NUMBER} oumaimaadmin/timesheetimage:timesheetimage'
               sh 'docker push oumaimaadmin/timesheetimage:timesheetimage'
           }
       }
       stage ('DOCKER COMPOSE') {
          steps {
               sh 'docker compose up -d'
          }
       }
    }
}
