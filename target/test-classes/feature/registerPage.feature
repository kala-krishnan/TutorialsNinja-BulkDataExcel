
@homePage
Feature: Register user
  Background:
    Given The user is in the register page
    
    Scenario Outline: the user has to be registered successfully
    When the user clicks continue button after giving the details using "<KeyOption>" and "<Sheetname>"
    Then the user has to be registered successfully
    Examples: 
      | KeyOption               | Sheetname        |
    	|RegisterValid            | Register         |
    	
    
    Scenario: The user is logging out Successfully
    When the user clicks logout option from MyAccount
    Then the user has to be logged out successfully
    	
    	
    Scenario Outline: the user has not to be registered
    Given The user is in the register page for invalid scenario
    When the user clicks continue button after giving invalid details using "<KeyOption>" and "<Sheetname>"
    Then the user should not be registered
     Examples: 
      | KeyOption                                         | Sheetname        |
    	|RegisterwithoutMandatoryFirstName                  | Register         |
    	|RegisterwithoutMandatoryLastName                   | Register         |
    	|RegisterwithoutMandatoryEmail                      | Register         |
    	|RegisterwithoutMandatoryTelephone                  | Register         |
    	|RegisterwithoutMandatoryPassword                   | Register         |
    	|RegisterwithoutMandatoryConfirmPassword            | Register         |
    	