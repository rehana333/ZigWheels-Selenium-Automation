```markdown
# ZigWheels Selenium Automation
A Selenium & Cucumber-based automation framework designed to identify upcoming bikes, extract used car details, and validate login error messages on ZigWheels or similar automotive websites.

## Project Overview
This project automates the following tasks using **Java, Selenium, and Cucumber**:
1. **Identify upcoming bikes** – Fetch bike names, prices, and expected launch dates for Honda bikes priced under ₹4,00,000.
2. **Extract used car details** – List popular used car models available in Chennai.
3. **Validate login error handling** – Attempt login with invalid Google credentials and capture the error message.

## Key Features
- **Web Automation** with Selenium WebDriver
- **Behavior-Driven Development (BDD)** using Cucumber
- **Handling Windows & Frames** for web interactions
- **Form Filling & Error Capturing**
- **Extracting Menu Items & Storing Data in Collections**
- **Navigation & Dynamic Web Element Handling**
- **Test Runner for Execution** using JUnit

## Tech Stack
- **Programming Language:** Java
- **Automation Tools:** Selenium WebDriver, Cucumber (BDD)
- **Test Runner:** JUnit
- **Build Tool:** Maven

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/rehana333/ZigWheels-Selenium-Automation.git
   ```
2. Navigate to the project directory:
   ```bash
   cd ZigWheels-Selenium-Automation
   ```
3. Install dependencies via Maven:
   ```bash
   mvn clean install
   ```
4. Run the **TestRunner** to execute Cucumber tests:
   ```bash
   mvn test
   ```
5. View test results in the console or generated reports.

## Project Structure
```
├── src
│   ├── main
│   │   ├── java (Framework & Helpers)
│   ├── test
│   │   ├── java (Step Definitions, Page Objects & Test Runner)
│   │   ├── resources (Feature Files)
│── pom.xml (Maven dependencies)
│── README.md (Project details)
```

## Test Execution
The **TestRunner** file is responsible for executing the Cucumber scenarios. It integrates with JUnit and ensures smooth test execution.

## Contributors
Created by **Rehana Sayyed** – Feel free to contribute!
```

