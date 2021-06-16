node() {

  stage('Checkout') {
    checkout(scm)
  }

  stage('Building') {
            sh """
            echo "hello this is testing"
            my_image = docker.build("test-app:${env.BUILD_ID}")
            echo $my_image
            echo my_image
            """

        }
  stage('Test') {
       // Assess the image
       assessContainerImage failOnPluginError: true,
           imageId: "${my_image.id}",
           thresholdRules: [
              exploitableVulnerabilities(action: 'Mark Unstable', threshold: '1')
            ],
            nameRules: [
              vulnerablePackageName(action: 'Fail', contains: 'nginx')
           ]
   }

  stage('Deploying') {
      dir('jenkins-k8s-slave') {
        
            withCredentials([file(credentialsId: 'jenkins-devops', variable: 'FILE')]) {
              sh """
                export GOOGLE_APPLICATION_CREDENTIALS=${env.FILE}
                gcloud auth activate-service-account --key-file=\"\$GOOGLE_APPLICATION_CREDENTIALS\"
                gcloud docker tag "${my_image.id}" gcr.io/p/test/test-jenkins-slave:test
                gcloud docker -- push gcr.io//test/test-jenkins-slave:test
              """
            }
        }
      }
    }

