Feature: Click Buttons on DemoQA page

  Background:
    Given the user navigates to the 'https://demoqa.com/elements' page

  Scenario: User clicks the button and sees the success message
    When the user clicks the buttons option and click me button
    Then the success message should be displayed
