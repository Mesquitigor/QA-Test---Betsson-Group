SwagLabs Mobile Test Automation

Project Overview

This project is a test automation framework designed for SwagLabs, a mobile e-commerce platform. The automation was developed as part of a technical test for Betsson Group. The goal is to ensure the functionality and reliability of the application by executing automated test scripts.

Tech Stack

Programming Language: Java

Test Framework: Cucumber

Mobile Automation: Appium

Build Tool: Maven

Test Runner: JUnit

Installation & Setup

Clone this repository:

git clone https://github.com/your-repo-link.git

Install dependencies using Maven:

mvn clean install

Start Appium Server.

Configure the config.properties file with the necessary device and app details.

Run the test suite:

mvn test

Test Execution

Tests are written in Gherkin syntax and stored in the features/ directory. Cucumber step definitions implement these test scenarios, interacting with the SwagLabs mobile app through Appium.

To execute tests, use the following command:

mvn test -Dcucumber.options="--tags @smoke"

Reporting

After test execution, reports will be generated in the target/cucumber-reports/ directory. The reports include detailed logs, screenshots of failures, and test results.

Contact

For any questions or clarifications regarding this project, feel free to reach out.

This project was developed as part of a technical assessment for Betsson Group.

