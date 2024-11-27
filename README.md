
# TestNG DailyFinance Automation

This project automates the **DailyFinance** workflows using **Selenium**, **TestNG**, and **Gradle**, ensuring robust and efficient test execution with detailed reporting.

## Project Overview
The project automates key user workflows such as:
- Registration
- Email confirmation
- Password reset
- Item listing
- Profile updates
- Admin verification

## Features
- **Page Object Model (POM):** A structured design pattern for maintainable and reusable code.
- **Allure Reporting:** Provides detailed and interactive test execution reports, making it easier to analyze results.
- **Gradle Build System:** Simplifies dependency management and task execution for seamless development workflow.
- **TestNG Suite:** Allows for grouping and running multiple test classes together.
- 
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


##Allure Reports

![image](https://github.com/user-attachments/assets/0b518399-b458-45c9-bead-79b723a4bab9)
![image](https://github.com/user-attachments/assets/7d4585a7-43b1-46a2-9ea4-57b3c3712887)
![image](https://github.com/user-attachments/assets/386fb513-254f-49d4-895a-d56c7bd53fb5)



