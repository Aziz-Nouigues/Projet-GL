pipeline {
    agent any

    environment {
        SONARQUBE_SCANNER = 'SonarQubeServer' // Nom du serveur SonarQube défini dans Jenkins
        SONAR_TOKEN = 'squ_17e226be93443186dfc843375e2a44e6e044a84e'     // Remplace ça avec ton vrai token
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: '28a2bc26-bfdd-459d-9b76-9de829161060',
                    url: 'https://github.com/Aziz-Nouigues/Projet-GL.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${SONARQUBE_SCANNER}") {
                    bat "mvn sonar:sonar -Dsonar.projectKey=JenkinsTest -Dsonar.host.url=http://localhost:9000 -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t springboot-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8081:8081 springboot-app'
            }
        }
    }
}
