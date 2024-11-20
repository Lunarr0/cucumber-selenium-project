Feature: Demo Blaze User Login

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect login attempts
    Given the 'Login' button is clicked
    And the 'login-Username' field is filled with '<username>'
    And the 'login-Password' field is filled with '<password>'
    When the 'login-User' button is clicked
    Then the '<errorMessage>' message is shown


    Examples:
      | username        | password       | errorMessage                           |
      |                 |                | Please fill out Username and Password. |
      | MikeTyson       |                | Please fill out Username and Password. |
      | NotMikeTyson2   |itisi          | User does not exist.                    |
      | MikeTyson       |secret_sauce   | Wrong password.                         |


  Scenario Outline: Correct login attempts
    Given the 'Login' button is clicked
    And the 'login-Username' field is filled with '<username>'
    And the 'login-Password' field is filled with '<password>'
    When the 'login-User' button is clicked
    Then the user is directed to 'https://www.demoblaze.com/index.html'
    Examples:
      | username      | password |
      | MikeTyson     | itisi    |
      | NotMikeTyson  | itisi    |