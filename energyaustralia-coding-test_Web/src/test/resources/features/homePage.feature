Feature: Home Page
@Home
  Scenario: Verify Details in Home Page
    Given User Launch Browser
    When User open URL "http://localhost:4200/festivals"
    Then Verify user landed to Home page
    And Verify festivals displayed
    Then Verify "Adrian Venti" festival
    And close browser
