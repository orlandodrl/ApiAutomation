pipeline {
    agent any

    stages {
        stage('Download Project GIT') {
            steps {
                git branch: 'main', url: 'https://github.com/orlandodrl/ApiAutomation.git'
            }
        }
        stage('Test API') {
            steps {
                withMaven(maven:'maven3.8.3'){
                    sh "mvn clean verify"
                }
            }
        }
    }

    post {
        always {
            publishHTML([allowMissing: false,
                         alwaysLinkToLastBuild: true,
                         keepAll: true,
                         reportDir: 'target/site/serenity/',
                         reportFiles: 'index.html',
                         reportName: 'Reporte de Pruebas Serenity',
                         reportTitles: 'Reporte de Pruebas Serenity'
            ])
        }
    }

}