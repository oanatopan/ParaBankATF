# 🏦 ParaBank UI Automation Project
A complete **end-to-end UI automation framework** built with Selenium WebDriver, Java, TestNG, and Page Object Model.


![Java](https://img.shields.io/badge/Java-17-007396?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Test%20Framework-red)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven)
![Allure](https://img.shields.io/badge/Allure-Test%20Reporting-FF6A00)
![CI](https://img.shields.io/badge/CI-GitHub%20Actions-blue?logo=githubactions)
![Automation](https://img.shields.io/badge/Test-Automation-success)

---

## 📑 Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Automated Test Scenarios](#automated-test-scenarios)
- [Application Under Test](#application-under-test)
- [Framework Architecture](#framework-architecture)
- [Project Structure](#project-structure)
- [Automation Design Decisions](#automation-design-decisions)
- [CI/CD Integration](#cicd-integration)
- [Test Reporting (Allure)](#test-reporting-allure)
- [Automation Benefits](#automation-benefits)
- [What Makes This Project Stand Out](#what-makes-this-project-stand-out)
- [Key Skills Demonstrated](#key-skills-demonstrated)
- [Contact](#contact--connect)

---

## 📌 Project Overview

This project represents an **end-to-end UI automation framework** developed for the ParaBank demo banking application.

The project demonstrates practical **QA automation engineering skills** by automating realistic banking workflows such as:

- user registration
- account management
- fund transfers
- bill payments
- loan requests
- transaction validation

---

## 🛠️ Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java** | Programming language |
| **Selenium WebDriver** | UI automation engine |
| **TestNG** | Test execution framework & parallel execution |
| **Maven** | Build and dependency management |
| **Page Object Model** | Design pattern for UI abstraction |
| **Jackson** | JSON test data management |
| **MySQL** | Test data storage |
| **JDBC** | Database connectivity |
| **Git / GitHub** | Version control |

---

## 📋 Prerequisites

Before running the tests, ensure you have the following installed:

- **Java SDK 17**
- **Apache Maven (3.6+)**
- **Google Chrome**
- **Allure Commandline**

---

## 🧪 Automated Test Scenarios

The automation suite contains **11 end-to-end UI tests** simulating real banking workflows.

| Test Case | Business Scenario | Description | Validation |
|---|---|---|---|
| RegisterTest | User Registration | Creates a new banking user account | Successful account creation |
| LoginValidTest | User Authentication | Logs in with valid credentials | Dashboard displayed |
| LoginInvalidTest | Validation | Invalid login attempt | Error message |
| OpenAccountTest | Account Creation | Opens new account | Account appears in overview |
| TransferFundsTest | Money Transfer | Transfers funds | Confirmation message |
| BillPayTest | Payment | Sends payment | Payment confirmation |
| RequestLoanTest | Loan | Requests loan | Approval / rejection |
| FindTransactionsTest | Search | Filters transactions | Correct results |
| AccountHistoryTest | Validation | Opens activity page | History visible |
| AccountsOverviewTest | Overview | Displays accounts | Table visible |
| LogOutTest | Session | Logs out | Login page displayed |

---

## 🌐 Application Under Test

🔗 https://parabank.parasoft.com/parabank

A demo banking platform that supports:

- account registration
- account creation
- fund transfers
- bill payments
- loan requests
- transaction tracking

---

## 🧱 Framework Architecture

The framework follows a **layered architecture using Page Object Model (POM)**.

### Key Layers:

- **Tests** → business logic & validations  
- **Pages** → UI interactions  
- **Helper Methods** → reusable actions  
- **Models** → structured test data  
- **SharedData** → setup & teardown  
- **Utils** → logging & listeners  

---

## 🗄️ Database Integration

The framework integrates a **MySQL database** for dynamic test data.

### Benefits:

- realistic test scenarios  
- centralized test data  
- reusable data across tests  
- cleaner test logic  

---

## 📂 Project Structure

```text
ParaBankATF
│
├── .github
│   └── workflows
│        ├── customPipeline.yml
│        ├── nightlyPipeline.yml
│        ├── regressionPipeline.yml
│        ├── databasePipeline.yml
│
├── allure-results
│
├── src
│   └── test
│        ├── java
│        │   ├── tests
│        │   ├── pages
│        │   ├── helpMethods
│        │   ├── sharedData
│        │   ├── modelObject
│        │   └── utils
│        │
│        └── resources
│             └── database
│                  └── init.sql
│
├── pom.xml
├── testng.xml
