# Lab 12: Managing Configuration and Sensitive Data

## Objective
Use Kubernetes ConfigMaps and Secrets to manage application configuration and sensitive values.

## ConfigMap
Created a ConfigMap named `ivolvecm` in the `ivolve` namespace.

Configuration keys:
- `DB_HOST`: `mysql` (example hostname; replace it with the actual MySQL headless Service name when available).
- `DB_USER`: `appuser`.

## Secret
Created an Opaque Secret named `ivolvesecret` in the `ivolve` namespace.

Secret keys:
- `MYSQL_ROOT_PASSWORD`
- `DB_PASSWORD`

The values in `secret.yaml` are Base64-encoded examples for this lab only. Base64 is encoding, not encryption. Never commit real passwords to a public repository.

## Apply the Resources
```bash
kubectl apply -f configmap.yaml
kubectl apply -f secret.yaml
```

## Verify the Resources
```bash
kubectl get configmap ivolvecm -n ivolve
kubectl get secret ivolvesecret -n ivolve
kubectl describe configmap ivolvecm -n ivolve
kubectl describe secret ivolvesecret -n ivolve
```

## Note
No MySQL StatefulSet or MySQL Service existed in the cluster during this lab. Update `DB_HOST` to the actual MySQL headless Service name when it becomes available.
