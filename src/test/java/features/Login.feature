Feature: Login functionality

  Scenario: Successful login
    Given I open the login page on "Chrome"
    When I enter valid credentials
    Then I should be logged in successfully

  Scenario: UnSuccessful login with invalid credentials
    Given I open the login page on "Chrome"
    When I enter invalid credentials
    Then I should see an error message

  Scenario Outline: Login with different credentials
    Given I open the login page on "<browser>"
    When I enter "<username>" and "<password>"
    Then I should "<result>" the login

    Examples:
      | browser | username |  | password | result               |
      | Chrome  | Admin    |  | admin123 | successfully         |
      | FireFox | Invalid  |  | Invalid  | see an error message |
