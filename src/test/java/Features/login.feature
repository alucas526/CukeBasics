# filename: Features/login.feature

Feature: LoginFeature
  This feature deals with the login functionality of the application. The application in question can be found
  at http://executeautomation.com/demosite/Login.html

  Scenario: Login with the correct username and password
    Given User navigates to the login page
    And User enters email address as Email:admin
    And User enters the following for login
      | username | password |
      | admin     | adminpassword |
    And User clicks the Login button
    And User verifies the number of digits in their salary of 500000 dollars
    Then User should see the userform page

  Scenario: Login with the correct username and password but then do something wrong
    Given User navigates to the login page
    And User enters the following for login
      | username | password |
      | admin     | adminpassword |
    And User clicks the Login button
    Then User should see the wrong info on the userform page

#  Scenario Outline: Login with the correct username and password using Scenario Outline
#    Given User navigates to the login page
#    And User enters email address as Email:admin
#    And User enters <username> and <password>
#    And User clicks the Login button
#    And User verifies the number of digits in their salary of 5000 dollars
#    Then User should see the userform page
#
#    Examples:
#      | username | password      |
#      | admin    | adminpassword |
#      | admin    | password      |
#      | admin    | admin         |
