pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    triggers {
        githubPush()
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge'], description: 'Select browser')
        choice(name: 'GROUP', choices: ['smoke', 'regression'], description: 'Select test group')
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'qa',
                    url: 'https://github.com/SanPanu/SauceDemoProject.git'
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -Dbrowser=${params.BROWSER} -Dgroups=${params.GROUP}"
            }
        }

        stage('Publish Reports') {
            steps {
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/**', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution completed.'
        }
        success {
            echo 'Build SUCCESS'
        }
        failure {
            echo 'Build FAILED'
        }
    }
}