#Feature: View task detail
#
#  Scenario Outline: View task detail
#    When I view task "<taskName>"
#    Then Verify add task detail
#      | taskName    | <taskName>    |
#      | description | <description> |
#      | priority    | <priority>    |
#      | label       | <label>       |
#      | projectName | <projectName> |
#
#    Examples:
#      | taskName | description | priority | label | projectName   |
#      | task1    |             |          |       |               |
#      | task2    | mo ta 1     |          |       |               |
#      | task3    |             | 1        |       |               |
#      | task4    |             | 2        |       |               |
#      | task5    |             | 3        |       |               |
#      | task7    |             |          | Salon |               |
#      | task8    |             |          |       | Salon Booking |
#      | task9    | mô tả full  | 1        | Salon | Salon Booking |
