# Lab 14 - MySQL StatefulSet

## Objective
Deploy MySQL using a Kubernetes StatefulSet, a Headless Service, and persistent storage.

## Resources
- StatefulSet: `ivolvedb`
- Headless Service: `ivolvedbsvc`
- PersistentVolume: `ivolvedb-pv`
- PersistentVolumeClaim: `ivolvedb-pvc`
- Namespace: `ivolve`
- Image: `mysql:8.0`

## Configuration
- One MySQL replica.
- Persistent data mounted at `/var/lib/mysql`.
- Credentials loaded from the existing Kubernetes Secret `ivolvesecret`.
- Database username loaded from the existing ConfigMap `ivolvecm`.
- Pod scheduled on the `project=ivolve` worker node.

## Verification
- MySQL Pod: `1/1 Running`
- StatefulSet: `1/1 Ready`
- PersistentVolumeClaim: `Bound`
