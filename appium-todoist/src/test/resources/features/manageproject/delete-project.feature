
Feature: Delete project

  Scenario: Delete project unsuccessful
    Given I click menu bar
    And I click Manage project
    When I click project name with "Retail"
    And I click delete project
    And I click cancel button
    Then I check delete project unsuccessful

  Scenario: Delete project successful
    Given I click menu bar
    And I click Manage project
    When I click project name with "Retail"
    And I click delete project
    And I click delete button
    Then I check delete project successful