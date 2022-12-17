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
                withSonarQubeEnv(installationName: 'SonarQube') {
                    sh "mvn clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar -Dsonar.projectKey=BrainTuck"
                }
            }
        }

        stage('Nexus') {
            steps {
                nexusArtifactUploader artifacts: [[artifactId: 'maven-project', classifier: '', file: '/var/jenkins_home/workspace/nexus/webapp/target/base-0.0.1-SNAPSHOT.jar', type: 'jar']], credentialsId: 'NEXUS3', groupId: 'com.example.maven-project', nexusUrl: '172.18.0.6:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0-SNAPSHOT'
            }
        }
    }
}
