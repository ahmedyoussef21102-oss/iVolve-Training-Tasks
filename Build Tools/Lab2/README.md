# Lab 2: Building and Packaging Application with Gradle

## Objective
Build, test, package, and run the calculator application using Gradle.

## Source Code
https://github.com/Ibrahim-Adel15/CalculatorGradleApp

Note: The repository contains a Java application, although the lab description mentions Go.

## Tools
- Java: OpenJDK 21
- Gradle: 8.14.3

## Unit Tests
Command: `gradle test`

Result: BUILD SUCCESSFUL. Five tests passed with no failures or errors.

## Build
Command: `gradle build`

Result: BUILD SUCCESSFUL.

Generated artifact: `build/libs/calculator.jar`

## Run
Command: `java -jar build/libs/calculator.jar`

## Verification
Input: 10 and 10

- Sum: 20.0
- Subtract: 0.0
- Multiply: 100.0
- Divide: 1.0

The application ran successfully and returned the expected results.
