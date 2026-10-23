# Lab 8: Containerized Node.js and MySQL Stack

## Overview
A Node.js application and MySQL database containerized using Docker Compose.

## Components
- Node.js application exposed on port 3000.
- MySQL 8.0 database named ivolve.
- Custom Docker network: ivolve-net.
- Persistent database volume: db_data.
- Persistent application logs volume: app_logs.
- MySQL health check.

## Docker Hub Image
[ahmedyoussef21102/ivolve-app:lab8](https://hub.docker.com/r/ahmedyoussef21102/ivolve-app)

## Run the Application
```bash
cd Docker/Lab8/iVolveApp
docker compose up -d --build
docker compose ps

## Verification

Open http://localhost:3000

## Screenshots
Screenshots will be added here.

## Screenshots

### Database
![Database](screenshots/database.png)

### Database Verification
![Database Verification](screenshots/database-verification.png)

### Volumes and Logs
![Volumes and Logs](screenshots/volumes-logs.png)
