# Lab 17 - Kubernetes Network Policy

## Objective
Create a NetworkPolicy to control incoming traffic to the MySQL database Pod.

## Network Policy Configuration

- Name: ivolvenp
- Namespace: ivolve
- Target Pod Label: app=ivolvedb
- Policy Type: Ingress
- Allowed Source Pod Label: app=ivolveapp
- Allowed Protocol: TCP
- Allowed Port: 3306

## Apply Network Policy

    kubectl apply -f ivolveNP.yaml

## Verification

    kubectl get networkpolicy -n ivolve
    kubectl describe networkpolicy ivolvenp -n ivolve

## Result
Configured an ingress NetworkPolicy that allows traffic only from application Pods to the MySQL database on TCP port 3306.
