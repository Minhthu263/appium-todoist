@check
Feature: Archive project

  Scenario: Archive project
    Given I click menu bar
    And I click Manage project
    When I click add project to Archive with project "edit1"
    And I choose cancel
    Then Verify add archive unsuccessful