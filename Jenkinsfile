node {

  stage('Checkout') {
    checkout(scm)
  }

  stage('Building') {
            echo "hello there"
            sh """
            echo "hello this is testing"
            docker build -t testing:latest .
            """

        }
  
    }

