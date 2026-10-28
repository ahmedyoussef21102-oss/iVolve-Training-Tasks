# Lab 13: Persistent Storage Setup for Application Logging

## Objective
Configure persistent storage for application logs using a PersistentVolume
(PV) and a PersistentVolumeClaim (PVC).

## Configuration
- PersistentVolume: ivolvepv
- PersistentVolumeClaim: ivolvepvc
- Namespace: ivolve
- Capacity: 1Gi
- Access mode: ReadWriteMany
- Reclaim policy: Retain
- Storage type: hostPath
- Host directory: /mnt/app-logs
- StorageClass: None

## Notes
Kubernetes resource names must be lowercase, so ivolvePV and ivolvePVC
are represented as ivolvepv and ivolvepvc.

The hostPath volume is local to a node. ReadWriteMany does not make
this directory shared across multiple nodes.

## Apply
kubectl apply -f pv-pvc.yaml

## Verify
kubectl get pv ivolvepv
kubectl get pvc ivolvepvc -n ivolve
