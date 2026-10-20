# Lab 1: Building and Packaging Java Application with Maven

## Objective
Build, test, package, and run a Java Calculator application using Maven.

## Prerequisites
- Java
- Apache Maven
- Git

## Source Code
https://github.com/Ibrahim-Adel15/CalculatorMavenApp

## Steps

### 1. Verify Java and Maven
Commands: `java -version` and `mvn -version`

### 2. Clone the Source Code
Repository: `CalculatorMavenApp`

### 3. Run Unit Tests
Command: `mvn test`

Result: 5 tests passed, 0 failures, 0 errors.

### 4. Build the Application
Command: `mvn package`

Result: BUILD SUCCESS.

Generated artifact: `target/calculator.jar`

### 5. Verify the Artifact
Command: `ls -lh target/calculator.jar`

Result: JAR file generated successfully (approximately 3.7 KB).

### 6. Run the Application
Command: `java -jar target/calculator.jar`

### 7. Verify the Output
Test input: 10 and 2.

Expected results:
- Sum: 12.0
- Subtract: 8.0
- Multiply: 20.0
- Divide: 5.0

All four results were verified successfully.

## Conclusion
The Java Calculator application passed its unit tests, was packaged into a runnable JAR, and executed successfully.
