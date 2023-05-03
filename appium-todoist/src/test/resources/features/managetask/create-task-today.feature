
Feature: Thêm mới task ngày hôm nay

  Scenario Outline: Tạo task
    Given I click icon Add Task
    When I input information
      | taskName    | <taskName>    |
      | description | <description> |
      | priority    | <priority>    |
      | label       | <label>       |
      | projectName | <projectName> |
    And I click Send button
    Then Verify add task

    Examples:
      | taskName | description | priority | label | projectName   |
      | task1    |             |          |       |               |
      | task2    | mo ta 1     |          |       |               |
      | task3    |             | 1        |       |               |
      | task4    |             | 2        |       |               |
      | task5    |             | 3        |       |               |
      | task7    |             |          | Salon |               |
      | task8    |             |          |       | Salon Booking |
      | task9    | mô tả full  | 1        | Salon | Salon Booking |
