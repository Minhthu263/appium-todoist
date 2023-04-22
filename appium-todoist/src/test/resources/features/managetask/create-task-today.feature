
Feature: Thêm mới task ngày hôm nay

  Background:
    Given Login in app

  Scenario Outline: Tạo task với trường requi
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
      | test     | mô tả       | 1        | Salon | Salon Booking |