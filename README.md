# SauceDemo Selenium Automation Framework

This is a robust, professional Test Automation Framework designed to test the login functionality of the SauceDemo website. It is built from scratch using **Java**, **Selenium WebDriver**, and **TestNG** using the **Page Object Model (POM)** design pattern.

---

## 🛠️ Tech Stack & Libraries
* **Language:** Java
* **Automation Library:** Selenium WebDriver
* **Testing Framework:** TestNG
* **Build Management:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Data Driven:** `config.properties` for dynamic credentials

---

## 📁 Framework Structure

```text
saucedemo-selenium-automation/
├── src/
│   ├── main/java/
│   │   ├── base/               # Browser setup and teardown (BaseTest.java)
│   │   ├── pages/              # Locators and Action Methods (LoginPage.java)
│   │   └── utilities/          # Properties file reader (ConfigReader.java)
│   ├── test/java/
│   │   └── tests/              # TestNG Execution Classes (LoginTest.java)
│   └── test/resources/         # Contains config.properties
├── SauceDemo_Login_TestCases.xlsx # Beautifully structured manual test cases sheet
├── testng.xml                  # Test suite runner
└── pom.xml                     # Maven dependencies
