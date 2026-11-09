# Lab 20: Jenkins Role-Based Authorization

## Objective
Configure Role-Based Authorization in Jenkins to control user permissions.

## Environment
- Jenkins Version: 2.555.2
- Operating System: Ubuntu 22.04
- Authorization Plugin: Role-based Authorization Strategy

## Tasks Performed

### 1. Install Role-Based Authorization Plugin
- Opened Manage Jenkins.
- Navigated to Plugins.
- Installed Role-based Authorization Strategy.
- Restarted Jenkins safely.

### 2. Create Jenkins Users
Created the following users:
- ahmed
- user1
- user2

### 3. Configure Global Roles

Created the following roles:

**admin**
- Assigned administrative permissions.

**readonly**
- Overall: Read
- Job: Read
- View: Read

### 4. Assign Roles

| User | Assigned Role |
|------|---------------|
| ahmed | admin |
| user1 | admin |
| user2 | readonly |

### 5. Verify Permissions

Logged in using user2 and verified:

- Successfully accessed the Jenkins Dashboard.
- Could not access Jenkins administration settings.
- Accessing `/manage` returned Access Denied.

Expected permission error:

`user2 is missing a permission, one of Overall/Manage, Overall/Administer is required.`

## Result

Successfully configured and tested Role-Based Authorization in Jenkins.

The admin user has administrative access, while user2 has read-only access.
