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
            	//sh 'chmod +x gradlew'
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
        /*
        * The SonarQube and Nexus staging is
        * commented because the AWS instance are terminated.
        */
        // stage('CODE ANALYSIS with SONARQUBE') {
          
		//   environment {
        //      scannerHome = tool 'SonarScannerServer'
        //   }

        //   steps {
        //     script {
        //         withSonarQubeEnv(credentialsId: 'sonar-auth-token') {
        //         sh './gradlew sonarqube'
        //         }
        //     }
        //   }
        // }

        // stage('Quality Gate Stage') {
        //   steps {
        //     script {
        //         waitForQualityGate abortPipeline: true, credentialsId: 'sonar-auth-token'
        //     }
        //   }
        // }

        // stage("Pushing artifact to Nexus") {
        //     steps {
        //     	sh 'ls -l /var/lib/jenkins/workspace/student-directory/build/libs'
        //         script {
        //             nexusArtifactUploader artifacts: 
        //             [[artifactId: 'student-directory', 
        //             classifier: '', 
        //             file: '/var/lib/jenkins/workspace/student-directory/build/libs/student-directory-1.0.0-boot.jar', 
        //             type: 'jar']], 
        //             credentialsId: 'nexus-auth', 
        //             groupId: 'student-directory', 
        //             nexusUrl: 'ec2-18-182-66-141.ap-northeast-1.compute.amazonaws.com:8081', 
        //             nexusVersion: 'nexus3', 
        //             protocol: 'http', 
        //             repository: 'student-directory-release', 
        //             version: '1.0.0'
        //         }
        //     }
        // }
        
        stage("Docker Image") {
            steps {
                script {
                    sh 'docker build -t $JOB_NAME:v1.$BUILD_ID .'
                    sh 'docker image tag $JOB_NAME:v1.$BUILD_ID therealvikash/$JOB_NAME:v1.$BUILD_ID'
                    sh 'docker image tag $JOB_NAME:v1.$BUILD_ID therealvikash/$JOB_NAME:latest'
                }
            }
        }
        stage("Pushing Docker Image") {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-id', variable: 'dockerhub-cred-hub')]) {
                        sh 'docker login -u therealvikash -p ${dockerhub-cred-hub}'
                        sh 'docker image push therealvikash/$JOB_NAME:v1.$BUILD_ID'
                        sh 'docker image push therealvikash/$JOB_NAME:latest'
                    }    
                }
            }
        }
    }
}