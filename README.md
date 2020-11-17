# StockTracker

## Framework to Automate Functionality of Web UI of Stock Tracker

### Prerequisite for the given application to work after the code is cloned from git 

To install the dependencies :
pip install -r requirements.txt

To run the API server:
$ python api.py

Run the Dev server:
$ npm run serve

Note : This can be created as bash and invoked in framework 

### Language used for Automation Framework is 
Java,TestNG,Cucumber ,Maven

### Test automation framework would be designed based on the listed factors, using the following guidelines.
* Application-independent.
* Easy to expand, maintain, and perpetuate.
* Encapsulate the testers from the complexities of the test framework
* Identify and abstract common functions used across multiple test scripts
* Decouple complex business function testing from navigation, limit-testing, and other simple verification and validation activities.
* Decouple test data from the test scripts
* Structure scripts with minimal dependencies - Ensuring scripts executing unattended even on failures

### Salient Feature Framework  :
1. Cucumber feature is used to create test cases. 
2. Test suite can be executed using cucumber tag ,that gives the flexibility to run the end user choice to select the test cases to be executed -This is achieved with FeatureFileRunner.class file.
3. The binding code can be used under step definitions.
4. Page object Model Design Pattern is used .
5. Cucumber ExtentTestNg report is used for reporting .
6. On Failure ,Method to take ScreenShot can be called(Not Implemented ).

### Steps to Execute the test cases 
1. Once the pre-requiste for launching the application is completed.
2. Clone the repo and launch the framework in eclipse IDE .
3. Right click on /Stocktracker/src/test/java/runner/FeatureFileRunner.java and select run as TestNG .
4. Once the selected cucumber tagged suite is executed ,the reports are stored under /Stocktracker/target/cucumber-html-reports .
5. Test data is can be stored in json and that in turn is stored as key - value pair .



