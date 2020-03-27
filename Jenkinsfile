pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('allure'){
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}