pipeline {
    agent any

    tools {
        maven 'Maven_3.9'
        jdk 'JDK17'
    }

    triggers {
        githubPush()
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome', 'edge'], description: 'Select browser')
        // GROUP parameter kept for future use — disabled for now
        // choice(name: 'GROUP', choices: ['smoke', 'regression'], description: 'Select test group')
    }

    stages {

        stage('Run Tests') {
            steps {
                // Groups disabled until @Test(groups) annotations are added
                sh "mvn clean test -Dbrowser=${params.BROWSER}"
            }
        }

        stage('Publish Reports') {
            steps {
                junit allowEmptyResults: true,
                      testResults: 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/**',
                                 fingerprint: true,
                                 allowEmptyArchive: true
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
