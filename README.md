
# TestNG DailyFinance Automation

This project automates the **DailyFinance** workflows using **Selenium**, **TestNG**, and **Gradle**, ensuring robust and efficient test execution with detailed reporting.

## Project Overview
The project automates key user workflows such as:
- Registration
- Admin login && Check Registered User
- User Login
- Item listing from CSV
- Filter item and Check amount 
- Profile updates


## Features
- **Page Object Model (POM):** A structured design pattern for maintainable and reusable code.
- **Allure Reporting:** Provides detailed and interactive test execution reports, making it easier to analyze results.
- **Gradle Build System:** Simplifies dependency management and task execution for seamless development workflow.
- **TestNG Suite:** Allows for grouping and running multiple test classes together.
  
## Prerequisites
Before running the project, ensure you have:
- **Java 8 or higher** installed.
- **Gradle** (or use the provided wrapper).
- **Google Chrome** and **ChromeDriver** installed.
- A valid internet connection to download dependencies.

## How to Set Up and Run
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/HurayJannat/TestNG_DailyFinance_Automation.git
   cd TestNG_DailyFinance_Automation


2.  Open the project from IntellIJ; File>Open>Select and expand folder>Open as project
3.  Hit this command: gradle clean test -PsuiteName="regressionSuite.xml" to run the regression suite or gradle clean test -PsuiteName="smokeSuite.xml"
4. Generate Allure report:
  allure generate allure-results --clean -output allure serve allure-results


## Allure Reports

![image](https://github.com/user-attachments/assets/d79c4a34-7b4b-4677-a27a-5ab99a0e87c1)
![image](https://github.com/user-attachments/assets/8c259ce7-cfa0-4caf-a58a-a26bab4a72e4)
![image](https://github.com/user-attachments/assets/55618b17-e524-4b91-a9dd-b63a80fec83b)



## Smoke Suit Video

https://github.com/user-attachments/assets/11f72f8c-aef3-4c21-ad10-5a98d27ac73a



