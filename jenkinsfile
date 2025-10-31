pipeline {
    agent any
tools {
        maven 'Maven3'
        jdk 'JDK21'
    }
stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/screenshots/**', allowEmptyArchive: true
        }
    }
}
