Feature: Login
@Home
  Scenario: Successful login with valid credentials
    Given User Launch Browser
    When User open URL "http://localhost:4200/festivals"
    Then Verify user landed to Home page
    And Verify festivals displayed
    And close browser