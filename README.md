<div align="center">

# 🏦 ParaBank – End-to-End UI Automation Framework

A complete end-to-end UI automation framework built with Selenium WebDriver, Java, TestNG, and Page Object Model for banking workflow automation, database state validation, and CI/CD integration.

![Java](https://img.shields.io/badge/Java-17-007396?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Test%20Framework-red)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven)
![Allure](https://img.shields.io/badge/Allure-Test%20Reporting-FF6A00)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql)
![CI](https://img.shields.io/badge/CI-GitHub%20Actions-blue?logo=githubactions)

</div>

---

## Table of Contents

* [Project Overview](#project-overview)
* [Tech Stack](#tech-stack)
* [Prerequisites](#prerequisites)
* [Automated Test Scenarios](#automated-test-scenarios)
* [Application Under Test](#application-under-test)
* [Framework Architecture](#framework-architecture)
* [Database Integration](#database-integration)
* [Project Structure](#project-structure)
* [Automation Design Decisions](#automation-design-decisions)
* [CI/CD Pipelines](#cicd-pipelines)
* [Allure Reporting](#allure-reporting)
* [Automation Benefits](#automation-benefits)
* [What Makes This Project Stand Out](#what-makes-this-project-stand-out)
* [Key Skills Demonstrated](#key-skills-demonstrated)
* [How to Run](#how-to-run)
* [Contact](#contact)

---

<a id="project-overview"></a>
## Project Overview

Built for [ParaBank](https://parabank.parasoft.com/parabank), a demo banking app. Covers registration, account management, fund transfers, bill payments, loan requests, and transaction filtering.

---

<a id="tech-stack"></a>
## Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java 17** | Programming language |
| **Selenium WebDriver 4.41** | UI automation engine |
| **TestNG 7.12** | Test execution and parallel runs |
| **Maven** | Build and dependency management |
| **Page Object Model** | UI abstraction layer |
| **Jackson** | JSON test data parsing |
| **MySQL 8.0** | Test data storage |
| **JDBC** | Database connectivity |
| **Log4j2** | Logging with custom Allure appender |
| **Allure 2.33** | Test reporting |
| **GitHub Actions** | CI/CD pipelines |

---

<a id="prerequisites"></a>
## Prerequisites

- Java SDK 17
- Apache Maven 3.6+
- Google Chrome
- Allure Commandline
- MySQL Server (default port 3306)

---

<a id="automated-test-scenarios"></a>
## Automated Test Scenarios

| Test Class | Business Scenario | Description | Validation |
|---|---|---|---|
| [RegisterTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/RegisterTest.java) | User Registration | Creates a new banking user via DB data | Success message displayed |
| [LoginValidTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/LoginValidTest.java) | User Authentication | Logs in with valid credentials | Log Out link visible |
| [LoginInvalidTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/LoginInvalidTest.java) | Validation | Invalid login attempt | Error title displayed |
| [OpenAccountTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/OpenAccountTest.java) | Account Creation | Opens a new savings account | New account ID generated |
| [TransferFundsTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/TransferFundsTest.java) | Money Transfer | Opens account and transfers funds | Transfer Complete message |
| [BillPayTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/BillPayTest.java) | Payment | Sends bill payment via DB data | Bill Payment Complete message |
| [RequestLoanTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/RequestLoanTest.java) | Loan Request | Requests a loan via DB data | Approved or Denied status |
| [FindTransactionsTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/FindTransactionsTest.java) | Search | Filters account activity | Correct title and panel visible |
| [AccountHistoryTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/AccountHistoryTest.java) | Validation | Opens account details page | Account Details title visible |
| [AccountsOverviewTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/AccountsOverviewTest.java) | Overview | Displays all accounts | Account table not empty |
| [LogOutTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/LogOutTest.java) | Session | Logs out of the application | Log In button visible |

---

<a id="application-under-test"></a>
## Application Under Test

https://parabank.parasoft.com/parabank

Demo banking app — registration, accounts, transfers, bill pay, loans, transaction history.

---

<a id="framework-architecture"></a>
## Framework Architecture

| Layer | Responsibility |
|:---|:---|
| **[Tests](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/tests)** | Business logic and assertions |
| **[Pages](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/pages)** | POM classes: [BasePage](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/pages/BasePage.java), [LoginPage](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/pages/LoginPage.java) and others |
| **[Helper Methods](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/helpMethods)** | Selenium wrappers with explicit waits: [ElementsMethods](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/helpMethods/ElementsMethods.java), [SelectMethods](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/helpMethods/SelectMethods.java) |
| **[Model Objects](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/modelObject)** | Test data classes — loaded from JSON or DB |
| **[Shared Data](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/sharedData/SharedData.java)** | WebDriver setup/teardown via TestNG hooks; screenshot on failure |
| **[Database](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/dataBase)** | [DataBaseConnection](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/dataBase/DataBaseConnection.java), [DataBaseQueries](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/dataBase/DataBaseQueries.java) |
| **[Utils](https://github.com/oanatopan/ParaBankATF/tree/master/src/test/java/utils)** | [LogUtility](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/LogUtility.java), [AllureAppender](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/AllureAppender.java), [TestListener](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/TestListener.java) |

---

<a id="database-integration"></a>
## Database Integration

Test data is loaded from MySQL through JDBC queries.

| Table | Used By |
| :--- | :--- |
| `register_data` | [RegisterTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/RegisterTest.java) |
| `bill_pay_data` | [BillPayTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/BillPayTest.java) |
| `loan_data` | [RequestLoanTest](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/RequestLoanTest.java) |

- changing a value in the DB applies to all tests — no code changes needed
- DB data is attached as HTML tables in Allure reports
- connection uses environment variables (`DB_URL`, `DB_USER`, `DB_PASSWORD`) — works the same locally and in CI

---

<a id="project-structure"></a>
## Project Structure

```text
ParaBankATF
│
├── .github
│   └── workflows
│        ├── customPipeline.yml
│        ├── nightlyPipeline.yml
│        ├── regressionPipeline.yml
│        └── databasePipeline.yml
│
├── src
│   └── test
│        ├── java
│        │   ├── dataBase
│        │   │   ├── DataBaseConnection.java
│        │   │   └── DataBaseQueries.java
│        │   ├── helpMethods
│        │   │   ├── ElementsMethods.java
│        │   │   └── SelectMethods.java
│        │   ├── modelObject
│        │   │   ├── BillPayModel.java
│        │   │   ├── FindTransactionsModel.java
│        │   │   ├── LoginModel.java
│        │   │   ├── OpenAccountModel.java
│        │   │   ├── RegisterModel.java
│        │   │   ├── RequestLoanModel.java
│        │   │   └── TransferFundsModel.java
│        │   ├── pages
│        │   │   ├── BasePage.java
│        │   │   ├── AccountActivityPage.java
│        │   │   ├── AccountDetailsPage.java
│        │   │   ├── AccountServicesPage.java
│        │   │   ├── AccountsOverviewPage.java
│        │   │   ├── BillPayPage.java
│        │   │   ├── LoginPage.java
│        │   │   ├── OpenAccountPage.java
│        │   │   ├── RegisterPage.java
│        │   │   ├── RequestLoanPage.java
│        │   │   └── TransferFundsPage.java
│        │   ├── sharedData
│        │   │   └── SharedData.java
│        │   ├── tests
│        │   │   ├── AccountHistoryTest.java
│        │   │   ├── AccountsOverviewTest.java
│        │   │   ├── BillPayTest.java
│        │   │   ├── FindTransactionsTest.java
│        │   │   ├── LoginInvalidTest.java
│        │   │   ├── LoginValidTest.java
│        │   │   ├── LogOutTest.java
│        │   │   ├── OpenAccountTest.java
│        │   │   ├── RegisterTest.java
│        │   │   ├── RequestLoanTest.java
│        │   │   ├── SuiteType.java
│        │   │   └── TransferFundsTest.java
│        │   └── utils
│        │       ├── AllureAppender.java
│        │       ├── LogUtility.java
│        │       └── TestListener.java
│        │
│        └── resources
│             ├── database
│             │   └── init.sql
│             ├── BillPayData.json
│             ├── FindTransactionsData.json
│             ├── LoginData.json
│             ├── OpenAccountData.json
│             ├── RegisterData.json
│             ├── RequestLoanData.json
│             ├── TransferFundsData.json
│             ├── allure.properties
│             ├── environment.properties
│             └── log4j2.xml
│
├── pom.xml
├── testng.xml
├── regressionSuite.xml
└── smokeSuite.xml
```

---

<a id="automation-design-decisions"></a>
## Automation Design Decisions

- [SharedData](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/sharedData/SharedData.java) — one user registered per suite via `@BeforeSuite`; WebDriver setup and teardown handled per test via `@BeforeMethod` / `@AfterMethod`
- [ElementsMethods](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/helpMethods/ElementsMethods.java) — explicit waits only, no `Thread.sleep()` anywhere
- [AllureAppender](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/AllureAppender.java) — custom Log4j2 plugin; each log line is written as an Allure step
- [TestListener](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/TestListener.java) — takes a screenshot on failure, copies `environment.properties` to Allure results
- [DataBaseQueries](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/dataBase/DataBaseQueries.java) — DB data attached as HTML tables in each test report
- [SuiteType](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/tests/SuiteType.java) — group name constants, no hardcoded strings in test annotations
- `RegisterTest` runs first in a separate `<test>` block — shared user is ready before parallel tests start
- `thread-count="3"` keeps parallel runs stable

---

<a id="cicd-pipelines"></a>
## CI/CD Pipelines

4 pipelines on GitHub Actions, each spinning up a MySQL 8.0 service container.

| Pipeline | Trigger | Suite | Allure Upload |
| :--- | :--- | :--- | :--- |
| [Regression Pipeline](https://github.com/oanatopan/ParaBankATF/blob/master/.github/workflows/regressionPipeline.yml) | Push to `master` / manual | `regressionSuite.xml` | Always |
| [Nightly Pipeline](https://github.com/oanatopan/ParaBankATF/blob/master/.github/workflows/nightlyPipeline.yml) | Scheduled Mon-Fri 21:00 UTC | `testng.xml` | Always |
| [Custom Pipeline](https://github.com/oanatopan/ParaBankATF/blob/master/.github/workflows/customPipeline.yml) | Manual — suite name as input | Any suite | Always |
| [Database Pipeline](https://github.com/oanatopan/ParaBankATF/blob/master/.github/workflows/databasePipeline.yml) | Manual | Full suite via `mvn clean install` | Always |

---

<a id="allure-reporting"></a>
## Allure Reporting

- Log4j2 logs are written as Allure steps via [AllureAppender](https://github.com/oanatopan/ParaBankATF/blob/master/src/test/java/utils/AllureAppender.java) — no manual `Allure.step()` calls needed
- screenshots attached on failure
- DB data attached as HTML tables per test
- pass/fail/skip summary, `@Feature` / `@Story` tags, environment info

---

<a id="automation-benefits"></a>
## Automation Benefits

| Benefit | Impact |
| :--- | :--- |
| **Fast feedback** | Issues caught on every push to master |
| **Consistency** | Same steps, same order, every run |
| **Parallel execution** | Full suite in under 2 minutes |
| **Regression safety** | All 11 scenarios run on every change |
| **CI/CD ready** | 4 pipelines — regression, nightly, custom, DB |
| **Reporting** | Steps, screenshots, DB data in every Allure report |

---

<a id="what-makes-this-project-stand-out"></a>
## What Makes This Project Stand Out

- 11 banking workflows covered end-to-end — registration, transfers, payments, loans, transaction search
- test data in MySQL, not hardcoded — one DB change applies everywhere
- Log4j2 logs become Allure steps automatically — no manual annotations needed
- 4 CI/CD pipelines running on every push and nightly
- one shared user per suite — parallel tests don't share state
- zero `Thread.sleep()` — explicit waits only

---

<a id="key-skills-demonstrated"></a>
## Key Skills Demonstrated

- Selenium WebDriver 4 with Java 17
- TestNG — parallel execution, listeners, groups, suite configuration
- Page Object Model with PageFactory
- Maven — build, dependencies, Surefire configuration
- GitHub Actions — service containers, scheduled and manual pipelines
- MySQL + JDBC with environment-based configuration
- Allure — custom Log4j2 appender, HTML attachments, environment properties
- Jackson for JSON test data
- Log4j2 custom plugin appender
- screenshot and debug snapshot on failure

---

<a id="how-to-run"></a>
## How to Run

**Run all tests**

```bash
mvn clean test
```

**Run a specific suite**

```bash
mvn test -DsuiteXmlFile=regressionSuite.xml
```

**Generate Allure report**

```bash
allure serve target/allure-results
```

---

<a id="contact"></a>
## Contact

**Oana Topan**
QA Automation Engineer

- GitHub: [github.com/oanatopan](https://github.com/oanatopan)
- LinkedIn: [linkedin.com/in/oanatopan](https://www.linkedin.com/in/oanatopan)
