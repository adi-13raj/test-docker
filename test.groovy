//label = "jenkins-node-${UUID.randomUUID().toString()}"
@Library('shared-jenkins-libraries') _

kubeNode(
  containers: [containerTemplate(name: 'docker', image: 'docker:latest', command: 'cat', ttyEnabled: true)],
  volumes: [
    //hostPathVolume(mountPath: '/home/jenkins/.docker/', hostPath: '/home/jenkins/.docker/'),
    //hostPathVolume(mountPath: '/usr/bin/docker', hostPath: '/usr/bin/docker'),
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
  ]
) {
  def imagename = "my_image:${env.BUILD_ID}"
  def  my_image

  stage('Checkout') {
    checkout(scm)
  }
container('docker') {
      stage('Build') {
       dir('rapid7-test') {
            my_image = docker.build("$imagename")
        }
      }
}
}
}
