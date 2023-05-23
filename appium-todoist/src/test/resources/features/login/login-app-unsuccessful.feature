@login @parallel1
Feature: Kiểm tra login app unsuccessful

  @parallel4
  Scenario: Login app with Email available
    Given I click Continue with more options
    And I click Login with Email
    And I click choose account
    When I input password with "123"
    And I click to Login
    Then Verify message login unsuccessful

  Scenario Outline: Login app with Email new3
    When I input username with "<username>"
    And I input password with "<password>"
    And I click to Login
    Then Verify message login unsuccessful

    Examples:
      | username               | password |
      | minhthu                | 123      |
      | minhthu@gmail.com      | 123      |
      | taminhthu263@gmail.com | 123      |

  Scenario: Login app with Email new
    When I input username with ""
    And I input password with "123"
    Then Verify button Login is disable

  Scenario: Login app with Email new2
    When I input username with "taminhthu263@gmail.com"
    And I input password with ""
    Then Verify button Login is disable
    And Close app



