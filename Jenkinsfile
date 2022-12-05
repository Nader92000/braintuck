pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                git branch:'master', credentialsId:'GIT_HUB_REPO',url:'https://github.com/GhofranAbdelwahab/braintuck.git'
                sh "mvn clean package"
            }

            post {
                success {
                    archiveArtifacts 'target/*.jar'
                    sh "ls ./target"
                }
            }
        }
    }
}
