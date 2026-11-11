# Lab 23 - Implementing a GitOps Workflow with Jenkins and Argo CD

## Overview
This lab implements a GitOps workflow using Jenkins, Docker Hub, Kubernetes, and Argo CD.

## Pipeline
1. Clone the DemoApp repository.
2. Build the Java application and run unit tests using the existing shared library.
3. Build, scan, and push the container image using the existing shared library.
4. Update the Lab23 Kubernetes Deployment manifest and push the change to GitHub.

## Argo CD
- Application: ivolve-lab23
- Repository: iVolve-Training-Tasks
- Manifest path: Jenkins/Lab23/k8s
- Namespace: ivolve
- Sync policy: Automated

## Jenkins requirements
- Agent label: rhel-agent
- Shared library: ivolve-shared-library
- Docker Hub credential: dockerhub-credentials
- GitHub credential: github-credentials

The Lab23 Kubernetes resources are separate from Lab22 resources.
