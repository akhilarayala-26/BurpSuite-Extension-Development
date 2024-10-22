# Burp Suite Extension Development using Montoya API

## Overview
This project involves developing custom extensions for Burp Suite using Java and the Montoya API to enhance web application security testing. The extensions modify HTTP requests, implement custom headers, manage scope, and enable data persistence and logging.

## Features
- **Custom HTTP Headers**: Dynamically add custom headers to relevant HTTP requests.
- **Logging**: Monitor and log extension activities for debugging and analysis.
- **Data Persistence**: Save and restore state variables upon extension reload.
- **Singleton Design Pattern**: Ensures efficient management of the Montoya API instance.
- **Scope Management**: Accurate tracking and filtering of requests within the defined scope.
- **Error Handling**: Robust exception management for secure and reliable extension performance.

### Setup Instructions

1. **Open the project** in IntelliJ IDEA (or any preferred IDE).
2. **Ensure** you have **JDK 17** and **Maven** installed.
3. **Add the necessary dependencies** for the Montoya API in your `pom.xml` file:

    ```xml
    <dependency>
        <groupId>com.example</groupId>
        <artifactId>montoya-api</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

### Usage

1. **Build the project** and create a `.jar` file.
2. In Burp Suite, go to the **Extender** tab.
3. Click **Add**, then select your `.jar` file to load the extension.
4. **Test the extension** by observing HTTP requests and responses with the custom header applied.

