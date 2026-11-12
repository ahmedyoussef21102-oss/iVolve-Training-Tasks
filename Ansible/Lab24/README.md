# Lab 24: Initial Ansible Configuration and Ad-Hoc Execution

## Objective
Configure Ansible on the control node, establish SSH connectivity
with a managed RHEL node, configure an inventory, and install Docker
using Ansible Ad-Hoc commands.

## Environment

| Component | Details |
|---|---|
| Control Node | Ubuntu 22.04 |
| Managed Node | Red Hat Enterprise Linux 10.1 |
| Control Node IP | 192.168.74.129 |
| Managed Node IP | 192.168.74.128 |
| Managed Hostname | nti.aiops |
| Ansible Version | 2.12.0 |
| SSH Key Type | ED25519 |

## 1. Ansible Installation and Verification

Ansible was already installed on the Ubuntu control node.

```bash
ansible --version
```

## 2. SSH Key Configuration

An ED25519 SSH key was available on the control node.

```bash
ssh-keygen -t ed25519
```

The managed node was reachable using SSH without an interactive
login password.

```bash
ssh ahmed-youssef@192.168.74.128 hostname
```

Expected hostname: `nti.aiops`

## 3. Ansible Inventory

File: `inventory.ini`

```ini
[managed]
rhel-worker ansible_host=192.168.74.128 ansible_user=ahmed-youssef
```

Test connectivity:

```bash
ansible all -i inventory.ini -m ping
```

Result: SUCCESS (pong).

## 4. Managed Node Information

Operating system: Red Hat Enterprise Linux 10.1.

```bash
ansible managed -i inventory.ini -m setup \
-a "filter=ansible_distribution*"
```

## 5. Docker Package Discovery

```bash
ansible managed -i inventory.ini -m shell \
-a "dnf list available 'docker*' 'podman-docker'"
```

Docker CE packages were available from the docker-ce-stable repository.

## 6. Docker Installation Using Ansible Ad-Hoc

```bash
ansible managed -i inventory.ini -b -K -m dnf \
-a "name=docker-ce,docker-ce-cli,containerd.io state=present"
```

Installation completed successfully.

Installed packages included:
- docker-ce 29.9.3
- docker-ce-cli 29.9.3
- containerd.io 2.4.2
- Docker Buildx plugin
- Docker Compose plugin

## 7. Start and Enable Docker Service

```bash
ansible managed -i inventory.ini -b -K -m shell \
-a "systemctl enable --now docker"
```

## 8. Final Verification

```bash
ansible managed -i inventory.ini -b -K -m shell \
-a "systemctl is-active docker && systemctl is-enabled docker && docker --version && rpm -q docker-ce docker-ce-cli containerd.io"
```

Verified results:
- Docker service: active
- Docker service: enabled
- Docker version: 29.9.3
- Docker CE, Docker CLI, and containerd.io installed successfully.

## Important Ansible Options

| Option | Description |
|---|---|
| `-i` | Specifies the inventory file |
| `-m` | Selects the Ansible module |
| `-a` | Passes module arguments |
| `-b` | Enables privilege escalation |
| `-K` | Prompts for the sudo/become password |
| `state=present` | Ensures the package is installed |
| `state=started` | Ensures the service is running |
| `enabled=yes` | Enables the service at boot |

## Conclusion

Lab 24 completed successfully.

Ansible connectivity to the RHEL managed node was verified,
Docker Engine was installed through an Ansible Ad-Hoc command,
and the Docker service was started and enabled.
