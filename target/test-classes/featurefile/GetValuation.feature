@getevaluation
Feature: MyPortfolio feature
  As a user ,I can add ,delete ticker

  Scenario: User can add a new ticker with valid units
  Given the application is launched
  When the user navigates to Portfolio Value
  Then verify that the value is zero
  When the user launch view portfolio
  When the user adds a ticker with units
  Then verify that the ticker is added
  When the user navigates to Portfolio Value
  Then verify that the value of that day is displayed
  When the user launch view portfolio
  And the user delete the ticker
  Then the ticker is not present

  
  
  
  

