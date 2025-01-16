
pipeline {
    agent any
    tools {
            maven 'mvn'
            jdk 'jdk'
    }
    stages {
        stage('Maven Compile'){
            steps {
                sh 'mvn compile'
            }
        }
        stage('Run Test'){
            steps {
               sh 'mvn clean test'
            }
        }
    }
    post {
         always {
            allure includeProperties: false, jdk: 'jdk', results: [[path: 'target/allure-results']]
        }
    }
}
