# Lab 28 - Ansible Dynamic Inventory

## Overview
This lab demonstrates Ansible Dynamic Inventory using the Constructed Inventory plugin and a local RHEL managed node instead of AWS EC2.

## Environment
- Control Node: Ubuntu 22.04.5
- Managed Node: RHEL 10.1
- Ansible Core: 2.12.0
- Web Server: Nginx 1.26.3

## Project Structure
```text
Lab28/
├── ansible.cfg
├── inventory/
│   ├── hosts.ini
│   └── dynamic_inventory.yml
├── site.yml
└── README.md
```

## Implementation
1. Configured a source inventory for the RHEL managed node.
2. Used the Constructed plugin to create dynamic inventory groups.
3. Verified connectivity using the Ansible ping module.
4. Installed Nginx from the local AppStream repository.
5. Deployed a custom HTML page and enabled the Nginx service.

## Verification
- Dynamic inventory graph generated successfully.
- Ansible ping returned pong.
- Nginx service status: active.
- HTTP returned the custom Lab28 page.
- Second playbook run: changed=0, failed=0.

## AWS Limitation
AWS EC2 integration was not executed because valid AWS credentials were unavailable. No AWS resources were created. This is a local alternative demonstrating Constructed Inventory, not an actual AWS EC2 dynamic inventory.

## Cleanup
To stop Nginx: sudo systemctl disable --now nginx
To uninstall Nginx: sudo dnf remove nginx
