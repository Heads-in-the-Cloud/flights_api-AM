pipeline {
    agent any

    stages {
        stage('System information') {
            steps {
                echo 'Printing useful info'
                sh 'ls'
                sh 'pwd'
            }
        }
        stage('Build') {
            steps {
                echo 'Attempting to build Docker image'
                sh 'docker build -t flights-api-am .'
            }
        }
        stage('Test') {
            steps {
                echo 'Run container and test'
            }
        }
    }
}
