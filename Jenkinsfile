pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    environment {
        POM_VERSION = readMavenPom().getVersion()
        POM_ARTIFACT_ID = readMavenPom().getArtifactId()
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
                def pom = readMavenPom file: 'pom.xml'
                nexusArtifactUploader(
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        nexusUrl: '172.18.0.6:8081',
                        groupId: 'com.braintuck',
                        version: POM_VERSION,
                        repository: 'maven-snapshots',
                        credentialsId: 'NEXUS3',
                        artifacts: [
                                [
                                        artifactId: 'base',
                                        classifier: '',
                                        file      : './target/base-'+POM_VERSION+'.jar',
                                        type      : 'jar'
                                ]
                        ]
                )
            }
        }
    }
}
