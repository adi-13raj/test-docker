node() {

  stage('Checkout') {
    checkout(scm)
  }

  stage('Building') {
            echo "hello there"
            sh """
            echo "hello this is testing"
            my_image = docker.build("test-app:${env.BUILD_ID}")
            echo $my_image
            echo my_image
            """

        }
  
    }

