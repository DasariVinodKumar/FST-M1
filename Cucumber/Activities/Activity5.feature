@Activity5
Feature: Data driven test without Examples
  Scenario Outline: Testing with data from scenario
    Given the user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then get the confirmation text and verify message as "<Message>"
    Examples:
    | Usernames | Passwords     | Message								|
    | admin     | password      | Welcome Back, Admin!  |
    | admin     | WrongPassword | Invalid credentials   |