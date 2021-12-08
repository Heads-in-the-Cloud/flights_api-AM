pipeline {
    agent { label 'aws-ready' }

    environment {
        commit = sh(returnStdout: true, script: "git rev-parse --short=8 HEAD").trim()
    }

    stages {
        stage('System information') {
            steps {
                echo 'Debug info:'
                sh 'ls'
                sh 'pwd'
            }
        }
        stage('AWS') {
            steps {
                echo 'logging in via AWS client'
                sh 'aws ecr get-login-password --region us-west-2 | docker login --username AWS --password-stdin 026390315914.dkr.ecr.us-west-2.amazonaws.com'
            }
        }
        stage('Build') {
            steps {
                echo 'Building Docker image'
                sh 'docker build -t am-flights-api .'
            }
        }
        stage('Push Images') {
            steps {
                echo 'Tagging images'
                sh 'docker tag am-flights-api:latest 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:latest'
                sh 'docker tag am-flights-api:latest 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:${commit}'
                echo 'Pushing images'
                sh 'docker push 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:latest'
                sh 'docker push 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:${commit}'
            }
        }
        stage('Cleanup') {
            steps {
                echo 'Removing images'
                sh 'docker rmi am-flights-api:latest'
                sh 'docker rmi 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:latest'
                sh 'docker rmi 026390315914.dkr.ecr.us-west-2.amazonaws.com/am-flights-api:${commit}'
            }
        }
    }
}
