
Feature: Chỉnh sửa project

  @PROJECT_03
  Scenario Outline: Chỉnh sửa project
    Given I click menu bar
    And I click Manage project
    When I click project name with "<projectNameOld>"
    And I click edit project
    And I edit project information
      | projectNameOld   | projectName   |  | color   | parent   | favorite   | view   |
      | <projectNameOld> | <projectName> |  | <color> | <parent> | <favorite> | <view> |
    And I click to V icon
    Then I check edit project successful

    Examples:
      | projectNameOld | projectName | color | parent        | favorite | view  |
      | Test           | edit1       |       |               |          |       |
      | edit1          |             | Green |               |          |       |
      | edit1          |             |       | Salon Booking |          |       |
      | edit1          |             |       |               | true     |       |
      | edit1          |             |       |               |          | Board |


