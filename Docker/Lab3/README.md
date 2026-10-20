# Lab 3: Containerization with Docker

## Source Application
https://github.com/Ibrahim-Adel15/CalculatorMavenApp

## Part 1: Build Inside Docker

- Used Maven with Java 17.
- Created a non-root user named appuser.
- Copied the source code into the image.
- Built the application inside Docker using Maven.
- Exposed port 8080.
- Built and tested the image app1 using container1.
- Verified all four calculator operations.
- Removed the container and image after verification.

**Measured image size:** 246,895,053 bytes (approximately 246.9 MB).

## Part 2: Build Locally

- Built the application locally using Maven.
- Used the Java 17 runtime image eclipse-temurin:17-jre-noble.
- Created a non-root user named appuser.
- Copied the generated JAR into the image.
- Exposed port 8080.
- Built and tested the image app2 using container2.
- Verified all four calculator operations.
- Removed the container and image after verification.

**Measured image size:** 94,270,203 bytes (approximately 94.3 MB).

## Bonus: Image Size Comparison

Part 1 uses a Maven image that includes build tools. Part 2 uses a Java runtime image and a prebuilt JAR. Part 2 is smaller by approximately 152.6 MB.

## Verification Results

For inputs 4 and 4:
- Sum: 8.0
- Subtract: 0.0
- Multiply: 16.0
- Divide: 1.0

The Maven test suite passed: 5 tests, 0 failures, 0 errors.

## Important Note

The calculator is an interactive console application, not an HTTP server. EXPOSE 8080 documents the requested port but does not make the application an HTTP server.
