Feature: Login functionality for the Swag Labs app

  @smoke
  Scenario: Successful Login with valid credentials
    Given I open the login page
    When I enter the username as "standard_user"
    And I enter the password as "secret_sauce"
    And I click the login button
    Then I should see the home page

  @regression
  Scenario: Unsuccessful Login with invalid username
    Given I open the login page
    When I enter the username as "invalid_user"
    And I enter the password as "secret_sauce"
    And I click the login button
    Then I should see an error message

  @regression
  Scenario: Unsuccessful Login with invalid password
    Given I open the login page
    When I enter the username as "standard_user"
    And I enter the password as "wrong_password"
    And I click the login button
    Then I should see an error message

  @smoke
  @regression
  Scenario: Unsuccessful Login with empty username
    Given I open the login page
    When I enter the username as ""
    And I enter the password as "secret_sauce"
    And I click the login button
    Then I should see an error message

  @smoke
  @regression
  Scenario: Unsuccessful Login with empty password
    Given I open the login page
    When I enter the username as "standard_user"
    And I enter the password as ""
    And I click the login button
    Then I should see an error message
