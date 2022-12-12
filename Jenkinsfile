pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('CheckOut') {
            steps {
                git branch: 'master', credentialsId: 'GIT_HUB_REPO', url: 'https://github.com/GhofranAbdelwahab/braintuck.git'
            }
        }

        stage('Unit Test') {
            steps {
                sh "mvn clean install -U"
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package"
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                    sh "ls ./target"
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(credentialsId: 'SonarQubeID', installationName: 'SonarQube') {
                    sh "mvn clean verify sonar:sonar -Dsonar.projectKey=BrainTuck"
                }
            }
        }
    }
}
