# Test Automation Analytics: UI & API Testing with Data Analysis and Machine Learning

## Project Overview
This project combines test automation and data science to analyze test results and extract insights from automated test executions.

The project includes UI and API test automation developed with Java, Selenium, RestAssured, and Cucumber. Test execution results are exported in JSON format and analyzed using Python in Google Colab.

The goal of this project is not only to automate tests but also to analyze test behavior, identify patterns, and explore how machine learning can be used to predict test outcomes.

## Technologies Used

Test Automation
- Java
- Selenium WebDriver
- RestAssured
- Cucumber (BDD)
- TestNG
- Maven

Data Analysis
- Python
- Pandas
- Matplotlib

Machine Learning
- Scikit-learn
- Logistic Regression
- Random Forest
- Test result prediction experiments

## Test Automation Scope

UI Tests
Automated UI test scenarios were developed using Selenium and Cucumber. These tests simulate user interactions and verify application behavior.

API Tests
API endpoints were tested using RestAssured. The tests validate API responses, status codes, and data consistency.

## Data Collection

After running automated tests, Cucumber JSON reports are generated. These reports include information such as:

- scenario name
- test status (passed / failed)
- test type (UI / API)

These test results are used as input for data analysis.

## Data Analysis

Using Python and Pandas, test execution results are analyzed to understand:

- pass/fail distributions
- UI vs API test ratios
- failure patterns
- trends in test outcomes

Visualizations are created using Matplotlib.

## Machine Learning Experiment

Machine learning models were trained on the test execution dataset to explore the possibility of predicting test outcomes.

The following models were experimented with:

- Logistic Regression
- Random Forest

These models were used to analyze patterns in test results and investigate whether automated test failures could be predicted based on historical execution data.

The goal of this experiment is to demonstrate how machine learning techniques can support quality engineering and improve test analysis processes.

## Project Structure

src  
Java automation test code (UI + API)

Reports/CucumberReport  
Generated test execution reports

data-analysis  
Data analysis scripts

test-automation-data-analysis.ipynb  
Google Colab notebook used for analysis and machine learning experiments

pom.xml  
Maven configuration file

## How to Run

1. Clone the repository
2. Install project dependencies
3. Run Cucumber test scenarios
4. Generate JSON reports
5. Analyze test results using the provided Python notebook
