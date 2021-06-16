node {

  stage('Checkout') {
    checkout(scm)
  }
  def customImage = docker.build("my-image:${env.BUILD_ID}")
  
  stage('Building') {
            echo "hello there"
            sh """
            echo "hello this is testing"
            docker build -t testing:latest .
            """

        }
  
    }

