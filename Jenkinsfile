pipeline {
    agent any

    tools {
        maven 'Maven_3.9'   // ← one name, used everywhere
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

        // ❌ REMOVE this stage — Jenkins already checks out automatically
        // stage('Checkout Code') { ... }

        stage('Run Tests') {
            steps {
                // ✅ No need for def mvnHome — tools block handles it
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
            echo 'Build SUCCESS ✅'
        }
        failure {
            echo 'Build FAILED ❌'
        }
    }
}
