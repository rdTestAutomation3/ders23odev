Feature: Adding and editing records

  Background:
    Given The user navigateweb to the 'https://demoqa.com/webtables' page

  Scenario: Adding and Editing a record in the WebTable
    When the user adds a new record with first name "Tuba", last name "Simsek", email "abcdg@gmail.com", age "30", salary "50000", and department "IT"
    When the user edits the record with name "Tuba Simsek" and updates the first name to "Adem"
    Then the updated record with name "Adem" should be visible in the table
