def imagename = "my-image:${env.BUILD_ID}"
node {

  stage('Checkout') {
    checkout(scm)
  }
  
  stage('Building') {
            echo "hello there"
            echo "$imagename"
            sh """
            echo "hello this is testing"
            docker --version
            """

        }
  
    }

