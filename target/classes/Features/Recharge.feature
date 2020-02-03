@regression
Feature: User recharge through the application

  Scenario: Verify if the user able to reach to the Payment screen or not.
    Given the user starts the application
    When the user fills operator and number in the respective field and clicks
    Then the user should navigate to Payment page

  Scenario: Verify if the user is able to pay from payment screen page
    Given the user starts the application
    And the user fills operator and number in the respective field and clicks
    And the user should navigate to Payment page
    When the user fills the details on payment page and clicks the pay button
    And the user fills the pop up with the given credentials
   Then the credentials should be validated

