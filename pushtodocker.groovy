def call(String Id,String app-name){
 withCredentials([usernamePassword(
                    credentialsId: "${Id}",
                    usernameVariable: "dockerhubuser",
                    passwordVariable: "dockerHubpass"
                )]) {
                    sh "docker login -u ${env.dockerhubuser} -p ${env.dockerHubpass}"
                    sh "docker image tag ${app-name}:latest ${env.dockerhubuser}/${app-name}:latest"
                    sh "docker push ${env.dockerhubuser}/${app-name}:latest"
                }
}
