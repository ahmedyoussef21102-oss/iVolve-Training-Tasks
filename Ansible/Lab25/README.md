# Lab 25: Automated Web Server Configuration Using Ansible Playbooks

## Objective
Automate Docker, kubectl, and Jenkins installation using Ansible Playbooks.

## Environment
- Control Node: Ubuntu 22.04.5
- Ansible Core: 2.12.0
- Managed Node: RHEL 10.1
- Inventory: ../Lab24/inventory.ini

## Implementation
The site.yml playbook:
1. Ensures Docker CE, Docker CLI, and kubectl are installed.
2. Enables and starts Docker.
3. Installs Java 21 and required dependencies.
4. Downloads the official Jenkins LTS repository.
5. Imports the Jenkins signing key.
6. Installs Jenkins.
7. Enables and starts Jenkins.
8. Verifies installed software and services.

## Execution
```bash
ansible-playbook -i Ansible/Lab24/inventory.ini Ansible/Lab25/site.yml -K
