Feature: Cascading Dropdown

  Scenario Outline: Verify we can handle Cascading Dropdown
    Given I open the Web page on "<browser>"
    When I Select State "<state>"
    Then I should Select "<city>" for "<state>"

    Examples:
      | browser | state | city  |
      | Chrome  | NCR   | Delhi |