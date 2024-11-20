Feature: Demo Blaze User Registration

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect registration attempts
    Given the 'signIn' button is clicked
    And the 'register-Username' field is filled with '<username>'
    And the 'register-Password' field is filled with '<password>'
    When the 'register-User' button is clicked
    Then the '<errorMessage>' message is shown


    Examples:
      | username       | password            | errorMessage                           |
      |                |                     |  Please fill out Username and Password.|
      | User1          |                     |  Please fill out Username and Password.|
      |                | itisi               |  Please fill out Username and Password.|
      |  User1         | itisi               | This user already exist.               |



