#This file has all the test scenarios related to Login feature
#Author of this file is Bharath
Feature: Login feature test scenarios of DemoBlaze application

  Scenario: Verify the succcessful Login functionality of DemoBlaze using valid credentails
    Given User opens the Browser
    When User navigate to the DemoBlaze application URL
    And User clicks on Login link
    And Enter user name as 'bharathedu1' and password as '123456'
    And clicks on Login button
    Then the home page should be displayed with welcome message
    And user clicks on Laptops link
    And user clicks on Laptop1 link
    And user closes the browser

    