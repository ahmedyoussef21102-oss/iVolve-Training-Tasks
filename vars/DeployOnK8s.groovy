def call() {
    withCredentials([
        file(
            credentialsId: 'kubeconfig-ivolve-deployer',
            variable: 'KUBECONFIG_FILE'
        )
    ]) {
        sh '''
            set -e
            export KUBECONFIG="$KUBECONFIG_FILE"

            sed "s|IMAGE_PLACEHOLDER|${IMAGE}|g" \
                Jenkins/Lab22/k8s/deployment.yaml > deployment-rendered.yaml

            kubectl apply -n ivolve -f deployment-rendered.yaml
            kubectl apply -n ivolve -f Jenkins/Lab22/k8s/service.yaml

            kubectl rollout status deployment/demoapp \
                -n ivolve --timeout=180s

            kubectl get deployments,services,pods -n ivolve -l app=demoapp
        '''
    }
}
