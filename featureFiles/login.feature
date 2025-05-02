Feature: Login Try

  Scenario: Login UnSuccessful
    Given the user navigates to the zigwheels page
    When the user clicks on the login button
    And clicks on the google
    Then the user enters the value as "abc@abc" 
    Then captures the error message