Feature: Login
#@Ignored
#  @Sanity
  Scenario: Successful login with valid credentials
    Given User Launch Browser
    When User open URL "https://LMG_QA:Landmark@123@uat5.maxfashion.com/ae/en"
    Then Click on country switcher
#    Then User enters Email as "admin@yourstore.com" and password as "admin"
#    And Click on Login
#    Then Page Title should be "Dashboard / nopCommerce administration"
#    When User click on Logout Link
#    Then Page Tittle should be "Your store. Login"
    And close browser



