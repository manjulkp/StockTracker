@myportfolio
Feature: MyPortfolio feature
  As a user ,I can add ,delete ticker

  Scenario: User can add a new ticker with valid units
  Given the application is launched
  When the user adds a ticker with units
  Then verify that the ticker is added
  When the user delete the ticker
  Then the ticker is not present

  Scenario: User can add a existing ticker to cover corner cases
  When the user adds a ticker with units
  Then verify that the ticker is added
  When the user tries to add the same ticker with same units
  Then verify that the ticker is added previously is not changed
  When the user delete the ticker
  Then the ticker is not present

  Scenario: User can add a different type ticker than the existing
  When the user adds a ticker with units
  Then verify that the ticker is added
  When the user adds a second type of ticker with units
  Then verify that the ticker is added
  When the user delete all added ticker
  Then the ticker is not present
  
  Scenario: User can update ticker with more ,less units 
  When the user adds a ticker with units
  Then verify that the ticker is added
  When the user adds the ticker with more units
  Then verify that the ticker is updated
  When the user adds the ticker with less units
  Then verify that the ticker is updated
  When the user delete all added ticker
  Then the ticker is not present
  
  #Scenario: User can add a new ticker with invalid units - negative numbers

  #Scenario: User can delete an existing ticker

  #Scenario: User can delete a non existing ticker
  
  #Scenario: User can delete all ticker

  #Scenario: Verification of units with decimal numbers  ,max number
  
  #Scenario: Verification of possible ticker that can be added 
  
  
  
  

