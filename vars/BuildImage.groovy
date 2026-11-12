def call() {
    def dockerUser = ''
    def image = ''

    try {
        withCredentials([
            usernamePassword(
                credentialsId: 'dockerhub-credentials',
                usernameVariable: 'DH_USER',
                passwordVariable: 'DH_TOKEN'
            )
        ]) {
            dockerUser = env.DH_USER
            image = "docker.io/${dockerUser}/demoapp:${env.BUILD_NUMBER}"

            sh """
                set -e
                podman build -t demoapp:${env.BUILD_NUMBER} .
                podman save -o demoapp-image.tar demoapp:${env.BUILD_NUMBER}

                trivy image --timeout 15m --input demoapp-image.tar \
                    --severity HIGH,CRITICAL --exit-code 0

                set +x
                echo "\$DH_TOKEN" | podman login docker.io \
                    --username "\$DH_USER" --password-stdin

                podman tag demoapp:${env.BUILD_NUMBER} '${image}'
                podman tag demoapp:${env.BUILD_NUMBER} \
                    'docker.io/${dockerUser}/demoapp:latest'

                podman push '${image}'
                podman push 'docker.io/${dockerUser}/demoapp:latest'
            """
        }

        env.IMAGE = image
        echo "Image published: ${image}"
        return image

    } finally {
        sh """
            podman logout docker.io || true
            podman rmi demoapp:${env.BUILD_NUMBER} || true
            rm -f demoapp-image.tar
        """
        if (dockerUser) {
            sh """
                podman rmi 'docker.io/${dockerUser}/demoapp:${env.BUILD_NUMBER}' || true
                podman rmi 'docker.io/${dockerUser}/demoapp:latest' || true
            """
        }
    }
}
