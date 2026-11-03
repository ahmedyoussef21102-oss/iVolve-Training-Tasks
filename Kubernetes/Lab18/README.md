# Lab 18 - Node-Wide Pod Management with DaemonSet

## Objective
Deploy Prometheus, Alertmanager, Grafana, and Node Exporter to monitor Kubernetes nodes.

## Components
- Prometheus: collects and stores metrics.
- Alertmanager: handles alerts from Prometheus.
- Grafana: visualizes metrics through a provisioned dashboard.
- Node Exporter: exposes host-level metrics on port 9100.
- DaemonSet: ensures a Node Exporter pod is scheduled on each eligible node.

## Deploy

    kubectl apply -f monitoring.yaml

## Validation

    kubectl get pods -n monitoring -o wide
    kubectl get daemonset -n monitoring
    kubectl get services -n monitoring

## Access
- Prometheus: http://NODE_IP:30090
- Alertmanager: http://NODE_IP:30093
- Grafana: http://NODE_IP:32000
- Node Exporter metrics: http://NODE_IP:9100/metrics

## Grafana Login
- Username: admin
- Password: admin

## Notes
The Grafana dashboard is provisioned automatically.
Node Exporter uses host networking and exposes metrics on port 9100.
Monitoring data uses ephemeral storage in this lab configuration.
