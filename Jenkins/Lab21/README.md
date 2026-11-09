# Lab 21: Jenkins Pipeline for Application Deployment

## Objective
Automate Java application build, Docker image creation, security scanning,
DockerHub publishing, and Kubernetes deployment using Jenkins Pipeline.

## Source Application
https://github.com/Ibrahim-Adel15/DemoApp

## Environment
- Ubuntu 22.04
- Java 21
- Maven 3.6.3
- Docker
- Jenkins
- Trivy
- Kubernetes
- Namespace: ivolve

## Pipeline Stages

1. Clone Application
2. Build Application using Maven
3. Build Docker Image
4. Scan Docker Image using Trivy
5. Push Docker Image to DockerHub
6. Delete Local Docker Images
7. Update Kubernetes Deployment Image
8. Deploy Application to Kubernetes

## DockerHub Credentials

Create a Jenkins credential with:

- Kind: Username with password
- ID: dockerhub-credentials
- Username: DockerHub username
- Password: DockerHub access token

## Kubernetes Resources

- Deployment: demoapp
- Service: demoapp-service
- Namespace: ivolve
- Replicas: 2
- Container Port: 8080

## Post Actions

- always: Runs after every pipeline execution.
- success: Reports successful pipeline execution.
- failure: Reports pipeline failure.

## Expected Result

The Java application is built, scanned, pushed to DockerHub,
and deployed to Kubernetes through Jenkins.
