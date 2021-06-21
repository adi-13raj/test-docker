label = "jenkins-node-${UUID.randomUUID().toString()}"

kubeNode(
  containers: [containerTemplates.docker()],
  volumes: [
    //hostPathVolume(mountPath: '/home/jenkins/.docker/', hostPath: '/home/jenkins/.docker/'),
    //hostPathVolume(mountPath: '/usr/bin/docker', hostPath: '/usr/bin/docker'),
    hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock')
  ]
) {
  def imagename = "my-image:${env.BUILD_ID}"

  stage('Checkout') {
    checkout(scm)
  }

  stage('Build') {
      dir('jenkins-k8s-slave') {
        container('jnlp') {
            def  my-image = docker.build("$imagename")
        }
      }
    }
}
