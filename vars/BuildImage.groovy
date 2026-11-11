def call() {
    def localImage = "demoapp:${env.BUILD_NUMBER}"

    try {
        sh """
            set -e
            podman build -t '${localImage}' .
            podman save -o demoapp-image.tar '${localImage}'
            trivy image --input demoapp-image.tar \
                --severity HIGH,CRITICAL \
                --exit-code 0
        """

        withCredentials([
            usernamePassword(
                credentialsId: 'dockerhub-credentials',
                usernameVariable: 'DH_USER',
                passwordVariable: 'DH_TOKEN'
            )
        ]) {
            sh """
                set +x
                echo "\$DH_TOKEN" | podman login docker.io \
                    --username "\$DH_USER" \
                    --password-stdin

                podman tag '${localImage}' \
                    "docker.io/\$DH_USER/demoapp:${env.BUILD_NUMBER}"

                podman tag '${localImage}' \
                    "docker.io/\$DH_USER/demoapp:latest"

                podman push "docker.io/\$DH_USER/demoapp:${env.BUILD_NUMBER}"
                podman push "docker.io/\$DH_USER/demoapp:latest"
            """
            env.IMAGE = "docker.io/${env.DH_USER}/demoapp:${env.BUILD_NUMBER}"
        }
    } finally {
        sh """
            podman logout docker.io || true
            podman rmi '${localImage}' || true
            podman rmi 'docker.io/\${env.DH_USER ?: "unused"}/demoapp:${env.BUILD_NUMBER}' || true
            podman rmi 'docker.io/\${env.DH_USER ?: "unused"}/demoapp:latest' || true
            rm -f demoapp-image.tar
        """
    }
}
