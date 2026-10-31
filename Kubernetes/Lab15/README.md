# Kubernetes Lab 15 - Node.js Application Deployment

- Deployment: ivolveapp
- Namespace: ivolve
- Replicas: 2
- Image: ahmedyoussef21102/ivolve-app:lab8
- ConfigMap: ivolvecm
- Secret: ivolvesecret
- PVC: ivolvepvc
- Init Container: MySQL 8.0
- Service: ivolveappsvc
- Service Type: ClusterIP
- Application Port: 3000

## Apply
kubectl apply -f ivolve-app.yaml

## Verify
kubectl get deployments,pods,services -n ivolve -o wide
kubectl get endpoints ivolveappsvc -n ivolve
kubectl logs deployment/ivolveapp -n ivolve --all-pods=true
