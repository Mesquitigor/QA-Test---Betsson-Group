Feature: Shopping Functionality in the Swag Labs App

  @smoke
  @regression
  Scenario: Successful selecting product
    Given I am on the home page
    When I add one product to the cart
    Then the cart badge should show some item
#
#  Scenario: Proceeding to checkout
#    Given I have a product in the cart
#    When I click on the checkout button
#    And I fill the checkout information
#    Then I should see the checkout information page
#
#  Scenario: Completing the purchase
#    Given I am on the checkout information page
#    When I review that it has an item
#    And I click the finish button
#    Then I should see the confirmation message "Thank you for your order!"