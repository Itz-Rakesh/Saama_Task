Feature: Dynamic Table Processing

  Scenario Outline: Verify User can able to select a row with the given data
    Given I landed on the WebPage on "Chrome"
    When I Select "<ColumnName>" and "<ColumnValue>"
    Then The "<ColumnName>" row for the "<ColumnValue>" value should be Selected

    Examples:
      | ColumnName | ColumnValue |
      | FirstName  | Will        |
      | LastName   | Diaz        |
