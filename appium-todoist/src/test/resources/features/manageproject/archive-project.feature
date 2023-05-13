@check
Feature: Archive project

  Scenario: Archive project unsuccessful
    Given I click menu bar
    And I click Manage project
    When I click add project to Archive
    And I choose cancel
    Then Verify add archive unsuccessful
    And I back to home page

  Scenario: Archive project unsuccessful
    Given I click menu bar
    And I click Manage project
    When I click add project to Archive
    And I choose archive
    Then Verify add archive successful
    And I back to home page

  Scenario: Archive project unsuccessful
    Given I click menu bar
    And I click Manage project
    And I click tab Archived
#    When I click add project to Unarchive with project "edit1"
    When I click add project to Unarchive
    And I choose cancel
    Then Verify add unarchive unsuccessful
    And I back to home page

  Scenario: Archive project successful
    Given I click menu bar
    And I click Manage project
    And I click tab Archived
    When I click add project to Unarchive
    And I choose unarchive
    Then Verify add unarchive successful
    And I back to home page