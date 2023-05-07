
Feature: Create task today

  Scenario: Create task unsuccessful
    Given I click icon Add Task
    When I input to Task name
    And I click Discard task
    Then Verify create task unsuccessful

  Scenario Outline: Create task successful
    Given I click icon Add Task
    When I input information
      | taskName    | <taskName>    |
      | description | <description> |
      | priority    | <priority>    |
      | label       | <label>       |
      | projectName | <projectName> |
    And I click Send button
    Then Verify add task
    When I view task "<taskName>"
    Then Verify add task detail
      | taskName    | <taskName>    |
      | description | <description> |
      | priority    | <priority>    |
      | label       | <label>       |
      | projectName | <projectName> |
    When I click complete task "<taskName>"
    Then Verify complete

    Examples:
      | taskName | description | priority | label | projectName   |
      | task1    |             |          |       |               |
      | task2    | mo ta 1     |          |       |               |
      | task3    |             | 1        |       |               |
      | task4    |             | 2        |       |               |
      | task5    |             | 3        |       |               |
      | task6    |             | 4        |       |               |
      | task7    |             |          | Salon |               |
      | task8    |             |          |       | Salon Booking |
      | task9    | mô tả full  | 1        | Salon | Salon Booking |
