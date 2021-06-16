def imagename = "my-image:${env.BUILD_ID}"
node {

  stage('Checkout') {
    checkout(scm)
  }
  def customImage = docker.build("$imagename")
  
  stage('Building') {
            echo "hello there"
            echo "$imagename"
            sh """
            echo "hello this is testing"
            """

        }
  
    }

