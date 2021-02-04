# SearchAuto

UI Automation

This is the sample test automation task in which below test scenario is included:

Scenario 1 

Scenario : User can search desired job post 
	Given User is in application home page and verify application header 
	Then Enter job title name  and Job Location and Distance 
	Then Click on More Option button and verify the section is displayed 
	Then Enter Min Salary and Max Salary and Salary Type and Job Type 
	Then Click on Find job button and verify the Job Search Header 
	Then User navigate back to the home page and verify home page is displayed  

Explanation

First scenario is tested for two different set of data using Scenario outline with example keyword .
The focus is only on the architecture not on the test cases. 

Tool Used :- 

Selenium Cucumber With BDD 

Advantage
It is one the efficient tool for testing
Quick and easy set up and execution
Style of writing tests allow for easier reuse of code in the tests
Feature file contains the scenarios which is written in Simple English language 
It allows automation of functional validation in easily readable and understandable format (like plain English) to Business Analysts, Developers, Testers, etc

Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpose

Prerequisites

Maven home: apache-maven-3.6.3

Java version: 1.8.0_231, vendor: Oracle Corporation

Chrome version: Version 88.0.4324.96  (Official Build) (64-bit)

This test was done on MAC but if you are running this code in windows then please download the chromedriver.exe file for windows and replace the file present in Chromedriver folder placed inside the project
File can be dowloaded from the below link 
https://chromedriver.storage.googleapis.com/index.html?path=88.0.4324.96/

Make sure your Chromedriver.exe file is compatible with your chrome version

Running the tests

Given scenario is automated using selenium cucumber. Gherkin language is used in cucumber for these scenario.

Below is the work flow of calling methods in this framework

Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for Automation demo in which scenario is written in gherkin language. This feature file calls step definition file through glue code. Then step definition file calls main page file in which all methods are defined.

Sarita Dash

04th Feb 2021
