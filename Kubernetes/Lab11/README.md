# Lab 11: Namespace Management and Resource Quota Enforcement

## Objective
Create a Kubernetes namespace and enforce a maximum number of Pods using ResourceQuota.

## Tasks Completed
1. Created the `ivolve` namespace.
2. Created a ResourceQuota named `ivolvequota`.
3. Set the maximum number of Pods to 3.
4. Created three test Pods successfully.
5. Attempted to create a fourth Pod and verified that Kubernetes rejected it because the quota was exceeded.
6. Deleted the temporary test Pods after verification.

## ResourceQuota Configuration
The quota is defined in `resource-quota.yaml`.

```yaml
apiVersion: v1
kind: ResourceQuota
metadata:
  name: ivolvequota
  namespace: ivolve
spec:
  hard:
    pods: "3"
```

## Verification
The quota reported:

- Used Pods: 3
- Maximum Pods: 3

The fourth Pod was rejected with an `exceeded quota` error.

## Note
The quota name uses lowercase letters because Kubernetes resource names must follow DNS naming rules.
