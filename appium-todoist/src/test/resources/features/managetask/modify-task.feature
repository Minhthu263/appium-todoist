@check
Feature: Modify task

  Scenario: Edit task
    Given I click menu bar
    And I click to Inbox
    And I create task
    When I click view task
    And I click edit task
    And I edit task infomation
    Then Verify edit task successful

    Scenario: Delete task unsuccessful
#      Given I click menu bar
#      And I click to Inbox
      When I click delete task
      And I choose No
      Then Verify delete task unsuccessful

    Scenario: Delete task successful
#      Given I click menu bar
#      And I click to Inbox
      When I click delete task
      And I choose Yes
      Then Verify delete task successful
