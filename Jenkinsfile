pipeline {
    agent { label 'aws-ready' }

    environment {
        commit = sh(returnStdout: true, script: "git rev-parse --short=8 HEAD").trim()
        aws-region = "us-west-2"
        aws-ecr-repo = "026390315914"
        repo-name = "am-flights-api"
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
                sh 'aws ecr get-login-password --region ${aws-region} | docker login --username AWS --password-stdin ${aws-ecr-repo}.dkr.ecr.${aws-region}.amazonaws.com'
            }
        }
        stage('Build') {
            steps {
                echo 'Building Docker image'
                sh 'docker build -t ${repo-name} .'
            }
        }
        stage('Push Images') {
            steps {
                echo 'Tagging images'
                sh 'docker tag ${repo-name}:latest ${aws-ecr-repo}.dkr.ecr.${aws-region}.amazonaws.com/${repo-name}:latest'
                sh 'docker tag ${repo-name}:latest ${aws-ecr-repo}.dkr.ecr.${aws-region}.amazonaws.com/${repo-name}:${commit}'
                echo 'Pushing images'
                sh 'docker push ${aws-ecr-repo}.dkr.ecr.${aws-region}.amazonaws.com/${repo-name}:latest'
                sh 'docker push ${aws-ecr-repo}.dkr.ecr.${aws-region}.amazonaws.com/${repo-name}:${commit}'
            }
        }
        stage('Cleanup') {
            steps {
                echo 'Removing images'
                sh 'docker rmi ${repo-name}:latest'
                sh 'docker rmi ${aws-ecr-repo}.dkr.ecr.us-west-2.amazonaws.com/${repo-name}:latest'
                sh 'docker rmi ${aws-ecr-repo}.dkr.ecr.us-west-2.amazonaws.com/${repo-name}:${commit}'
            }
        }
    }
}
