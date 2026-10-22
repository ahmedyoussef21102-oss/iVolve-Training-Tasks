Lab 5 - Trivy Image Vulnerability Scanning

Target Docker image:
trivy-lab:v1

Scan commands:
trivy image --scanners vuln --format json --output ../reports/trivy-full.json trivy-lab:v1

trivy image --scanners vuln --severity HIGH,CRITICAL --format json --output ../reports/trivy-high-critical.json trivy-lab:v1

Reports:
- trivy-full.json: Full vulnerability scan report.
- trivy-high-critical.json: HIGH and CRITICAL vulnerability report.

Scan findings:
- HIGH and CRITICAL vulnerabilities were detected.
- A CRITICAL vulnerability was reported for the tar package.
- Debian 11.11 was detected, and Trivy warned that this OS version is no longer supported.

Note:
Review the reports and update vulnerable dependencies and the base image where applicable.
