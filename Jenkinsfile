node {

  stage('Checkout') {
    checkout(scm)
  }
  def customImage = docker.build("my-image:${env.BUILD_ID}")
  
  stage('Building') {
            echo "hello there"
            echo $customImage
            sh """
            echo "hello this is testing"
            """

        }
  
    }

