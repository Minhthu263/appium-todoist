Feature: Comment project

  Scenario: Comment project
    Given I click menu bar
    And I click Manage project
    When I click Comment project
    And I input comment with "Comment 1"
    Then Verify comment successful

  Scenario: Edit Comment unsuccessful
    When I click edit comment
    And I input edit comment with "Comment edit"
    And I click cancel button
    Then Verify comment unsuccessful

  Scenario: Edit Comment successful
    When I click edit comment
    And I input edit comment with "Comment edit"
    And I click ok button
    Then Verify edit comment successful

  Scenario: Delete Comment unsuccessful
    When I click delete comment
    And I click no button
    Then Verify delete comment unsuccessful

  Scenario: Delete Comment successful
    When I click delete comment
    And I click yes button
    Then Verify delete comment successful
    And Close app
