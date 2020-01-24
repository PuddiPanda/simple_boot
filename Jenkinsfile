pipeline {
    agent any
    
    tools {
        maven 'M3'
    }
    
    stages {
        stage ('Checkout') {
            steps {
                git url: 'https://github.com/PuddiPanda/simple_boot.git'
                sh 'echo "--=-- Checout stage --=--"'
            }
        }
        
        stage ('Compile') {
            steps {
                sh 'echo "--=-- Compile Stage --=--"'
                sh 'mvn compile'
            }
        }
        
        stage('Test') {
            
            steps {
                sh 'echo "--=-- Test Stage --=--"'
                sh 'mvn test'
            }
            
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('Code coverage') {
            steps {
                jacoco (
                    execPattern: 'target/*.exec',
                    classPatern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    excluisionPattern: 'src/test*'
                )
            }
        }
        
        stage('Sanity check') {
            steps {
                sh 'echo "--=-- Sanity check test projet --=--"'
                sh 'mvn checkstyle:checkstyle'
            }
        }
        
        stage('Package') {
            steps {
                sh 'echo "--=-- Package Stage --=--"'
                sh 'mvn package'
            }
            post {
                always {
                    recordIssues enabledForFailure: true, tools: [checkStyle()]
                }
            }
        }
        

    }
}
