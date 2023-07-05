Feature: Login2
@Sanity
  Scenario Outline: Failed login with Invalid credentials with Data Driven
    Given User Launch Browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    Then User enters Email as "<email>" and password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout Link
    Then Page Tittle should be "Your store. Login"
    And close browser

    Examples:
      | email                  | password |
      | admin123@yourstore.com | admin    |