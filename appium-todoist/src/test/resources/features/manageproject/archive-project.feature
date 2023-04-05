Feature: Archive project

  Scenario: Archive project
    Given I click menu bar
    And I click Manage project
    When I click add project to Archive with project "Hi"
    Then Verify add archive successful