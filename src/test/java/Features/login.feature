Feature: LoginFeature
  This feature deals with the login functionality of the application. The application in question can be found
  at http://executeautomation.com/demosite/Login.html

  Scenario: Login with the correct username and password
    Given User navigates to the login page
    And User enters the following for login
      | Username | Password      |
      | admin    | adminpassword |
    And User clicks the Login button
    Then User should see the userform page