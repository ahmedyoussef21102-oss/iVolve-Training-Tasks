# Lab 27: Securing Sensitive Data with Ansible Vault

## Objective
Create a MySQL-compatible database role and encrypt sensitive credentials.

## Implementation
- Installed MariaDB Server and PyMySQL.
- Created the ivolve database.
- Created ivolveuser with ALL privileges on ivolve.
- Encrypted the database password using Ansible Vault.
- Connected using ivolveuser and executed SHOW DATABASES.

## Structure
- site.yml
- group_vars/all/vault.yml
- roles/mysql/tasks/main.yml

## Execution
ansible-playbook -i Ansible/Lab24/inventory.ini Ansible/Lab27/site.yml -K --vault-password-file ~/.ansible_vault_pass_lab27

## Result
Database configuration and user access validation completed.
