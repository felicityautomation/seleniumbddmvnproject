#This file has all the test scenarios related to Login feature
#Author of this file is Bharath
Feature: Login feature test scenarios of DemoBlaze application

  Background: 
    Given User opens the Browser
    When User navigate to the DemoBlaze application URL
    And User clicks on Login link

  Scenario: Verify the succcessful Login functionality of DemoBlaze using valid credentails
    And Enter user name as 'bharathedu1' and password as '123456'
    And clicks on Login button
    Then the home page should be displayed with welcome message
    And user closes the browser

  Scenario: Verify the Login functionality of DemoBlaze using invalid credentails
    And Enter user name as 'bhar232athedu1' and password as '899812'
    And clicks on Login button
    Then Alert message with error should be shown to the user
    And user closes the browser
