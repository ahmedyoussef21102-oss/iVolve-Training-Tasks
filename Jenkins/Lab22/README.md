# Lab 22 - CI/CD Pipeline with Jenkins Agents and Shared Libraries

## Shared Library
The repository root contains `vars/`:
- `BuildApp.groovy`: builds the application and runs unit tests.
- `BuildImage.groovy`: builds, scans, pushes, and removes the local image.
- `DeployOnK8s.groovy`: updates the Kubernetes deployment and deploys it.

## Jenkins Agent
Configure a permanent SSH agent:
- Node name: `rhel-agent`
- Label: `rhel-agent`
- Host: `192.168.74.128`
- Remote root: `/home/ahmed-youssef/jenkins-agent`
- SSH user: `ahmed-youssef`
- Java path: `/home/ahmed-youssef/.local/java/current/bin/java`

## Global Pipeline Library
Manage Jenkins > System > Global Pipeline Libraries:
- Name: `ivolve-shared-library`
- Default version: `main`
- Retrieval: Modern SCM > Git
- Repository: `https://github.com/ahmedyoussef21102-oss/iVolve-Training-Tasks.git`

## Jenkins Credentials
Create these credentials:
1. `dockerhub-credentials`: Username with Docker Hub access token as password.
2. `kubeconfig-ivolve-deployer`: Secret file containing a kubeconfig for the `ivolve` namespace deployer service account.

## Pipeline
Create a Pipeline job pointing to:
`Jenkins/Lab22/Jenkinsfile`
