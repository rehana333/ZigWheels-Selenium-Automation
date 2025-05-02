Feature: Successful Search

  Scenario: Search Successful
    Given the user is on the zigwheels page
    When the user clicks on the search button
    And the user enters the search value("Upcoming Bikes")
    Then check the results based on conditions 
