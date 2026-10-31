# Lab 16 - Pod Resource Management

## Objective
Configure CPU and memory requests and limits for the ivolveapp Deployment.

## Resource Configuration

### Requests
- CPU: 1
- Memory: 1Gi

### Limits
- CPU: 2
- Memory: 2Gi

## Verification

Check resource configuration:

    kubectl describe pod <pod-name> -n ivolve
    kubectl top pods -n ivolve

## Metrics Server
Installed Metrics Server to enable resource monitoring through the Kubernetes Metrics API.

## Result
Successfully configured resource requests and limits and verified actual Pod resource usage.
