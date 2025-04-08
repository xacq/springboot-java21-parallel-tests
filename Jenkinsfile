pipeline {
    agent any
    tools {
        jdk 'JDK21'       // Name of the JDK 21 installation in Jenkins
        maven 'Maven_3_8' // Adjust to your Maven installation name in Jenkins
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile -DskipTests'
            }
        }
        stage('Test') {
            parallel {
                stage('Test on Java 21') {
                    steps {
                        sh 'mvn test'
                    }
                    post {
                        always {
                            junit '**/target/surefire-reports/*.xml'
                        }
                    }
                }
                stage('Test on Java 17') {
                    environment {
                        JAVA_HOME = "${tool 'JDK17'}"
                        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
                    }
                    steps {
                        sh 'mvn test -Djava.version=17'
                    }
                    post {
                        always {
                            junit '**/target/surefire-reports/*.xml'
                        }
                    }
                }
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
