@parallel1
Feature: Modify task

  Scenario: Edit task unsuccessful when not enter taskname
    Given I click menu bar
    And I click to Inbox
    And I create task
    When I click view task
    And I click edit task
    And I edit task information with ""
    Then Verify edit task unsuccessful

  Scenario: Edit task unsuccessful when click back
    And I click edit task
    And I edit task information
    And I click Back
    Then Verify edit task unsuccessful when back

  Scenario: Edit task successful
    When I click edit task
    And I edit task information
    And I click to Save
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
