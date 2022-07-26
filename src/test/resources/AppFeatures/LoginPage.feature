Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "ParaBank | Welcome | Online Banking"

  Scenario: Forgot password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "dummy"
    And user enters password "Selenium@12345"
    And user clicks on login button
    Then user gets the title of the page
    And page title should be "ParaBank | Accounts Overview"
