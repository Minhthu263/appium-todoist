@check
Feature: Kiểm tra login app

  Scenario: Login app
    When I click Continue with Google
    When I choose account
    Then Verify login successful