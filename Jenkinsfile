pipeline {
    agent any
    stages {
        stage('Initialize') {
            steps {
                echo 'Guarantee integrity'
                ls
                pwd
            }
        }
        stage('Build') {
            steps {
                echo 'Attempting to build Docker image'
                docker build -t flights-api-am .
            }
        }
        stage('Test') {
            steps {
                echo 'Run container and test'
            }
        }
        stage('Clean') {
            steps {
                echo 'Removing created resources'
                docker images
                docker rmi flights-api-am
            }
        }
    }
}
