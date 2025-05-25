#This file has all the test scenarios related to Login feature
#Author of this file is Bharath
Feature: Login feature test scenarios of DemoBlaze application

  Scenario Outline: Verify the succcessful Login functionality of DemoBlaze using valid credentails
    Given User opens the Browser
    When User navigate to the DemoBlaze application URL
    And User clicks on Login link
    And Enter user name as '<username>' and password as '<password>'
    And clicks on Login button
    Then the home page should be displayed with welcome message
    And user closes the browser

    Examples: 
      | username    | password |
      | bharathedu1 |   123456 |
      | bharathedu2 | welcome1 |
