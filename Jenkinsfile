
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Agathiyan-Aadhi/DevOps_CI_24BCS011.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -version'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Result') {
            steps {
                echo 'Build and test completed successfully.'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
