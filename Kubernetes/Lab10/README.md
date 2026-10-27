# Lab 10: Node Isolation Using Taints and Labels in Kubernetes

## Objective
Configure a Kubernetes worker node using a label and a taint to control workload scheduling.

## Cluster Information
- Control Plane: `nti-virtual-machine`
- Worker Node: `nti.aiops`
- Kubernetes Version: `v1.36.5`
- Worker Node IP: `192.168.74.128`

## 1. Apply a Label

Command:

    kubectl label node nti.aiops project=ivolve

Result: The label was successfully applied.

## 2. Apply a Taint

Command:

    kubectl taint node nti.aiops workload=ivolveApp:NoSchedule

Result: The taint was successfully applied.

The taint prevents new Pods from being scheduled on this node unless they have a matching toleration.

## 3. Verify Node Labels

Command:

    kubectl get nodes --show-labels

Verified label:

    project=ivolve

## 4. Verify Node Taints and Status

Command:

    kubectl describe node nti.aiops

Verified taint:

    workload=ivolveApp:NoSchedule

The worker node status was `Ready`, and Calico networking was running successfully.

## Result

- Successfully joined the worker node to the Kubernetes cluster.
- Applied the required label: `project=ivolve`.
- Applied the required taint: `workload=ivolveApp:NoSchedule`.
- Verified the configuration using Kubernetes commands.
