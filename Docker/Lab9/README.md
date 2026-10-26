# Lab 9: Deploy Kubernetes Cluster Using Kubeadm

## Objective
Deploy a Kubernetes cluster using kubeadm, containerd, and Calico.

## Environment
- OS: Ubuntu 22.04.5 LTS
- Kubernetes: v1.36.5
- Container Runtime: containerd v2.2.3
- Control Plane IP: 192.168.74.129
- CNI: Calico v3.31.3

## 1. Configure containerd
```bash
sudo systemctl enable --now containerd
sudo systemctl restart containerd
```

## 2. Configure Kernel Networking
```bash
sudo modprobe overlay
sudo modprobe br_netfilter
sudo sysctl --system
```

## 3. Disable Swap
```bash
sudo swapoff -a
swapon --show
```

## 4. Install Kubernetes Tools
```bash
sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
sudo apt-mark hold kubelet kubeadm kubectl
sudo systemctl enable --now kubelet
```

## 5. Initialize the Control Plane
```bash
sudo kubeadm init --apiserver-advertise-address=192.168.74.129 --pod-network-cidr=10.244.0.0/16
```

## 6. Configure kubectl
```bash
mkdir -p "$HOME/.kube"
sudo cp -i /etc/kubernetes/admin.conf "$HOME/.kube/config"
sudo chown "$(id -u):$(id -g)" "$HOME/.kube/config"
```

## 7. Install Calico Network
```bash
kubectl apply -f https://raw.githubusercontent.com/projectcalico/calico/v3.31.3/manifests/calico.yaml
```

## 8. Verify the Cluster
```bash
kubectl get nodes -o wide
kubectl get pods -n kube-system
```

## Verified Results
- Control plane node status: Ready.
- Core Kubernetes and Calico pods: Running.

## 9. Worker Node
Generate a join command on the control plane:
```bash
sudo kubeadm token create --print-join-command
```

Run the generated command on a separately prepared worker node.

**Current status:** The control plane and Calico were verified successfully. A worker node still needs to be joined to complete the multi-node cluster requirement.
