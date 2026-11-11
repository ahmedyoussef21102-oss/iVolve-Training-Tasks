def call() {
    if (!env.IMAGE) {
        error('IMAGE is empty. BuildImage must run first.')
    }

    withCredentials([
        usernamePassword(
            credentialsId: 'github-credentials',
            usernameVariable: 'GH_USER',
            passwordVariable: 'GH_TOKEN'
        )
    ]) {
        sh '''
            set -eu

            rm -rf gitops-repo

            cat > git-askpass.sh <<'ASKPASS'
#!/bin/sh
case "$1" in
    *Username*) printf '%s\\n' "$GH_USER" ;;
    *) printf '%s\\n' "$GH_TOKEN" ;;
esac
ASKPASS
            chmod 700 git-askpass.sh

            export GIT_ASKPASS="$PWD/git-askpass.sh"
            export GIT_TERMINAL_PROMPT=0

            git clone --depth 1 \
                https://github.com/ahmedyoussef21102-oss/iVolve-Training-Tasks.git \
                gitops-repo

            cd gitops-repo

            # Update the image in the Git-tracked Kubernetes manifest
            sed -i -E \
                "s#(^[[:space:]]*image:[[:space:]]*).*#\\1${IMAGE}#" \
                Jenkins/Lab22/k8s/deployment.yaml

            git config user.name "Jenkins GitOps"
            git config user.email "jenkins-gitops@users.noreply.github.com"

            git add Jenkins/Lab22/k8s/deployment.yaml

            if git diff --cached --quiet; then
                echo "No deployment changes to push."
            else
                git commit -m "GitOps: update DemoApp image to ${IMAGE}"
                git push origin HEAD:main
                echo "Deployment update pushed to GitHub."
            fi

            cd ..
            rm -rf gitops-repo git-askpass.sh
        '''
    }
}
