pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'ls -al'
                sh 'mvn -Dmaven.test.skip=true clean package -f ucms/pom.xml' 
            }
        }

        stage('Deploy') {
            steps{
                sh 'java -jar ucms/biz/target/biz-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}