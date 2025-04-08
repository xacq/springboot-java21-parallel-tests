pipeline {
    agent any
    tools {
        // Las definiciones de JDK en Jenkins
        jdk 'JDK21'
    }
    stages {
        stage('Test') {
            parallel {
                stage('Test on Java 21') {
                    steps {
                        // Aquí compilamos y testeamos con Java 21
                        bat 'mvn clean compile'
                        bat 'mvn test'
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
                        // Aquí compilamos y testeamos con Java 17
                        bat 'mvn clean compile -Djava.version=17'
                        bat 'mvn test -Djava.version=17'
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
                // Elige una rama para empaquetar (o vuelve a compilar con la versión que quieras)
                bat 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
