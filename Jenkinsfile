pipeline {
    agent any
    tools {
        gradle '7.6.1' 
    } 
    stages {
        stage("Git Checkout") {
            steps {
                git branch: 'main', url: 'https://github.com/adyant0208/student-directory.git'
            }
        }
         stage("Gradle Build") {
            steps {
            	sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }
        stage("Gradle Test") {
            steps {
                sh './gradlew test'
            }
        }
        stage("Gradle Check") {
            steps {
                sh './gradlew check'
            }
        }
        stage("Gradle BuildEnvironment") {
            steps {
                sh './gradlew buildEnvironment'
            }
        }
        stage('CODE ANALYSIS with SONARQUBE') {
          
		  environment {
             scannerHome = tool 'SonarScannerServer'
          }

          steps {
            script {
                withSonarQubeEnv(credentialsId: 'sonar-auth-token') {
                sh './gradlew sonarqube'
                }
            }
          }
        }

        stage('Quality Gate Stage') {
          steps {
            script {
                waitForQualityGate abortPipeline: true, credentialsId: 'sonar-auth-token'
            }
          }
        }

        stage("Pushing artifact to Nexus") {
            steps {
            	sh 'ls -l /var/lib/jenkins/workspace/student-directory/build/libs'
                script {
                    nexusArtifactUploader artifacts: 
                    [[artifactId: 'student-directory', 
                    classifier: '', 
                    file: '/var/lib/jenkins/workspace/student-directory/build/libs/student-directory-1.0.0-SNAPSHOT-boot.jar', 
                    type: 'jar']], 
                    credentialsId: 'nexus-auth', 
                    groupId: 'student-directory', 
                    nexusUrl: 'ec2-43-207-81-106.ap-northeast-1.compute.amazonaws.com:8081', 
                    nexusVersion: 'nexus3', 
                    protocol: 'http', 
                    repository: 'student-directory-release', 
                    version: '1.0.0-SNAPSHOT'
                }
            }
        }
    }
}