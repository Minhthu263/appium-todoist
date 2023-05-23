@parallel2
Feature: Create task different today

  Scenario: Create task in the past
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name in the past
    And I click Send button
    Then Verify create task unsuccessful

  Scenario: Create task tomorrow
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name
    And I choose Tomorrow
    And I click Send button
    Then Verify add task different today

  Scenario: Create task This weekend
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name
    And I choose This weekend
    And I click Send button
    Then Verify add task different today

  Scenario: Create task any day
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name
    And I choose any day
    And I click Send button
    Then Verify add task different today

  Scenario: Create task click schedule
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name
    And I choose schedule
    And I click Send button
    Then Verify add task different today

  Scenario: Create task no date
    Given I click menu bar
    And I click to Inbox
    And I click icon Add Task
    When I input to Task name
    And I click Send button
    Then Verify add task no due date
