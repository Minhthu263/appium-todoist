@login @parallel1
Feature: Kiểm tra login app successful

  @parallel3
  Scenario: Login app with Google
    When I click Continue with Google
    When I choose account
    Then Verify login successful

  Scenario: Login app with Email
    Given I click Continue with more options
    And I click Login with Email
    And I click choose account
    When I input password with "263@1234"
    And I click to Login
    Then Verify login successful

  Scenario: Login app with Email new
    Given I click Continue with more options
    And I click Login with Email
    And I click to None of the above
    When I input username with "taminhthu263@gmail.com"
    And I input password with "263@1234"
    And I click to Login
    Then Verify login successful
