Feature: Login to SauceDemo

  Scenario Outline: Valid login scenarios
    Given The user navigates to the SauceDemo login page
    When The user enters username "<username>" and password "<password>"
    And The user clicks on the login button
    Then The user should see the products page with title "Products"

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: Invalid login scenarios
    Given The user navigates to the SauceDemo login page
    When The user enters username "<username>" and password "<password>"
    And The user clicks on the login button
    Then The user should see the error message "<error_message>"

    Examples:
      | username          | password       | error_message                                         |
      | locked_out_user   | secret_sauce   | Sorry, this user has been locked out                  |
      | problem_user      | wrong_password | Username and password do not match any user in this service |
