
Feature: Thêm mới task ngày hôm nay

  Background:
    Given Login in app

  Scenario: Tạo task với trường requi
    Given I click icon Add Task
    And I input information
    When I click Send button
    Then Verify add task