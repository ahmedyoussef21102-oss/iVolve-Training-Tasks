# Lab 19 - Securing Kubernetes with RBAC and Service Accounts

## Objective
Create a ServiceAccount and configure namespace-scoped RBAC permissions.

## Configuration
- Namespace: ivolve
- ServiceAccount: jenkinssa
- Role: ivolveDeployRole
- RoleBinding: ivolve-deployrolebinding
- Allowed Resource: deployments
- Allowed Verbs: create, update
- API Group: apps

## Apply Configuration

    kubectl apply -f rbac.yaml

## Create ServiceAccount Token

    kubectl create token jenkinssa -n ivolve

## Validation

    kubectl auth can-i create deployments --as=system:serviceaccount:ivolve:jenkinssa -n ivolve
    kubectl auth can-i update deployments --as=system:serviceaccount:ivolve:jenkinssa -n ivolve
    kubectl auth can-i delete deployments --as=system:serviceaccount:ivolve:jenkinssa -n ivolve
    kubectl auth can-i create deployments --as=system:serviceaccount:ivolve:jenkinssa -n default
