@check
Feature: Thêm mới project

  Scenario: Thêm mới dự án thành công khi nhập tên
    Given I click menu bar
    And I click Manage project
    When I click + Add project
    And I input Project Name with "số 1"
    And I click to V icon
    Then I check create project successful

  Scenario: Thêm mới dự án thành công khi nhập tên
    Given I click menu bar
    And I click Manage project
    When I click + Add project
    And I input Project Name with "số 2"
    And I choose Color with "Red"
    And I choose Parent with "Task mới"
    And I choose Favorite
    And I choose View Board
    And I click to V icon
    Then I check create project successful