# Lab 26: Structured Configuration Management with Ansible Roles

## Objective
Create separate Ansible roles for Docker, kubectl, and Jenkins, then execute them using one playbook.

## Environment
- Control Node: Ubuntu 22.04.5
- Ansible Core: 2.12.0
- Managed Node: RHEL 10.1
- Inventory: Ansible/Lab24/inventory.ini

## Project Structure
- roles/docker/tasks/main.yml
- roles/kubectl/tasks/main.yml
- roles/jenkins/tasks/main.yml
- site.yml

## Roles
1. Docker: Installs Docker packages and enables the Docker service.
2. kubectl: Installs kubectl.
3. Jenkins: Installs Java and dependencies, configures the Jenkins repository and signing key, installs Jenkins, and starts the service.

## Execution
ansible-playbook -i Ansible/Lab24/inventory.ini Ansible/Lab26/site.yml -K

## Verification
- Playbook syntax check passed.
- All three roles executed successfully on the managed node.
- PLAY RECAP: ok=10, changed=0, unreachable=0, failed=0.

## Result
All Lab 26 requirements were successfully implemented using separate Ansible roles.
