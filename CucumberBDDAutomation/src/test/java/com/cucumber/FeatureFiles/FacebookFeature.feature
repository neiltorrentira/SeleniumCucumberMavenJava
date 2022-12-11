@Important

Feature: Browse Facebook
  I want to browse and enter name at Facebook in my feature file

Background: Common steps
    Given Open Facebook

Scenario: Enter Firstname at Facebook scenario
    When User click Create New Account
#    And User enters "Jesse" first name
#    Then User validate Firstname "Jesse"
    Then User Closes Browser
    
Scenario: Validate create user multiple fields at Facebook
    When User click Create New Account
#    And User enters Firstname "Walter" and lastname "White"
#    Then User validate Firstname "Walter" and lastname "White"
    Then User Closes Browser
