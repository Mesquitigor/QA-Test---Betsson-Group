# SwagLabs Mobile Test Automation

## 📌 Project Overview
This project is a test automation framework designed for **SwagLabs**, a mobile e-commerce platform. The automation was developed as part of a technical test for **Betsson Group**. The goal is to ensure the functionality and reliability of the application by executing automated test scripts.

## 🛠 Tech Stack
- **Programming Language**: Java ☕
- **Test Framework**: Cucumber 🥒
- **Mobile Automation**: Appium 📱
- **Build Tool**: Maven ⚙️
- **Test Runner**: JUnit ✅

## 🚀 Installation & Setup
### 1️⃣ Clone this repository:
```sh
git clone https://github.com/your-repo-link.git
```

### 2️⃣ Install dependencies using Maven:
```sh
mvn clean install
```

### 3️⃣ Start Appium Server.

### 4️⃣ Configure the `config.properties` file with the necessary device and app details.

### 5️⃣ Run the test suite:
```sh
mvn test
```

## 🔄 Test Execution
Tests are written in **Gherkin syntax** and stored in the `features/` directory. Cucumber step definitions implement these test scenarios, interacting with the **SwagLabs mobile app** through **Appium**.

To execute tests with specific tags, use:
```sh
mvn test -Dcucumber.options="--tags @smoke"
```

## 📊 Reporting
After test execution, reports will be generated in the `target/cucumber-reports/` directory. The reports include:
✅ Detailed logs
📸 Screenshots of failures
📈 Test results

## 📩 Contact
For any questions or clarifications regarding this project, feel free to reach out.

---
This project was developed as part of a **technical assessment** for **Betsson Group**.
