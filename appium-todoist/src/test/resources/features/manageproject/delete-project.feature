@check
Feature: Delete project

  Scenario: Comment project
    Given I click menu bar
    And I click Manage project
    When I click project name with "edit1"
    And I click delete project
    And I click cancel button
    Then I check create project successful