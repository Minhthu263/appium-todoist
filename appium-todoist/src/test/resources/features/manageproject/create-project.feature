@parallel1
Feature: Create project

  Scenario: Create project success when input name
    Given I click menu bar
    And I click Manage project
    When I click + Add project
    And I input Project Name with "Connect"
    And I click to V icon
    Then I check create project successful

  Scenario: Create project success when input full information
    Given I click menu bar
    And I click Manage project
    When I click + Add project
    And I input Project Name with "Retail"
    And I choose Color with "Red"
    And I choose Parent with "Salon Booking"
    And I choose Favorite
    And I choose View Board
    And I click to V icon
    Then I check create project successful

