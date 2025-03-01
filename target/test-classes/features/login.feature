#Feature: Login functionality for the Swag Labs app
#
#  @smoke
#  @regression
#  Scenario: Successful Login with valid credentials
#    Given I open the login page
#    When I enter the username as "standard_user"
#    And I enter the password as "secret_sauce"
#    And I click the login button
#    Then I should see the home page
#
#  @smoke
#  @regression
#  Scenario: Unsuccessful Login with invalid username
#    Given I open the login page
#    When I enter the username as "invalid_user"
#    And I enter the password as "secret_sauce"
#    And I click the login button
#    Then I should see an error message
#
#  @regression
#  Scenario: Unsuccessful Login with invalid password
#    Given I open the login page
#    When I enter the username as "standard_user"
#    And I enter the password as "wrong_password"
#    And I click the login button
#    Then I should see an error message
#
#  @smoke
#  @regression
#  Scenario: Unsuccessful Login with empty username
#    Given I open the login page
#    When I enter the username as ""
#    And I enter the password as "secret_sauce"
#    And I click the login button
#    Then I should see an error message
#
#  @smoke
#  @regression
#  Scenario: Unsuccessful Login with empty password
#    Given I open the login page
#    When I enter the username as "standard_user"
#    And I enter the password as ""
#    And I click the login button
#    Then I should see an error message
#
#  @smoke
#  Scenario: Unsuccessful Login with lock out user
#    Given I open the login page
#    When I enter the username as "lock_out_user"
#    And I enter the password as "secret_sauce"
#    And I click the login button
#    Then I should see an error message
#
#  @smoke
#  Scenario: Successful Login but with problems on home page
#    Given I open the login page
#    When I enter the username as "problem_user"
#    And I enter the password as "secret_sauce"
#    And I click the login button
#    Then I should see the home page
#    And I click to add some item to cart
#    And I can not add another item to cart
#    And I can not remove item from cart
