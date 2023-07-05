@MaxCheckOut @RegressionSuite
Feature: Checkout
  Verify all UI components in checkout page
  Verify functional flows in checkout page Home Delivery-Credit/Debit Card-Guest User
  Verify functional flows in checkout page Click and Collect-Credit/Debit Card-Guest User
  Verify functional flows in checkout page Home Delivery-Cash on Delivery-Guest User
  Verify Cash On Delivery visible in Disabled mode in Click & Collect-Guest User
  Verify functional flows in checkout page Home Delivery-Credit/Debit Card-Register User
  Verify functional flows in checkout page Click and Collect-Credit/Debit Card-Register User
  Verify functional flows in checkout page Home Delivery-Cash on Delivery-Register User
  Verify Cash On Delivery visible in Disabled mode in Click & Collect-Registered User
  Background:
    Given User landed to home page
    When User navigate to product detail page
    Then User click on Add to Basket button


  Scenario: Verify all UI components in checkout page
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    Then User click on "Checkout As A Guest"
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And Verify all UI components in
      | deliveryType    |
      | click & Collect |
      | Home Delivery   |

  Scenario: Verify functional flows in checkout page Home Delivery-Credit/Debit Card-Guest User
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    Then User click on "Checkout As A Guest"
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType  |
      | Home Delivery |
    Then enter shipping "Address" details for guest user
    And User enter "contact" details
    Then User change address type as "Home" for guest user
    And User click on Proceed To Payment
    Then User enter "visa" card details
    And click on Pay now Button
    Then User navigate to thankyou page


  Scenario: Verify functional flows in checkout page Click and Collect-Credit/Debit Card-Guest User
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    Then User click on "Checkout As A Guest"
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType    |
      | click & Collect |
    Then User search and select "cairo" city
    And User enter "contact" details
    And User click on Proceed To Payment
    Then User enter "visa" card details
    And click on Pay now Button
    Then User navigate to thankyou page


  Scenario: Verify functional flows in checkout page Home Delivery-Cash on Delivery-Guest User
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    Then User click on "Checkout As A Guest"
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType  |
      | Home Delivery |
    Then enter shipping "Address" details for guest user
    And User enter "contact" details
    And User change address type as "Home" for guest user
    And User click on Proceed To Payment
    Then User choose Cash on Delivery
    And click on Pay now Button
    Then User navigate to thankyou page


  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page


  Scenario: Verify Cash On Delivery visible in Disabled mode in Click & Collect-Guest User
    Then User click on basket icon
    Then User click on checkout
    Then User click on "Checkout As A Guest"
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType    |
      | click & Collect |
    Then User search and select "cairo" city
    And User enter "contact" details
    And User click on Proceed To Payment
    Then Verify Cash on Delivery option disabled


  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page


  Scenario Outline: Verify functional flows in checkout page Home Delivery-Credit/Debit Card-Register User
    Then User click on login link and navigate to login page
    Then customer enter valid "<email>" and password "<password>"
    Then User landed to registered home page
    And  User click on myAccount drop icon
    Then user click on myAccount section from dropdown icon
    Then User click on address book section in my account page
    Then delete all address from address list from my account addresses
    Then verify user landed to add address page
    Then user click on add address from add address page
    And user add new address details in add address page
    Then user click on save button for add address
    And Verify saved address details in address list in myAccount
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    And Verify user landed to checkout page
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType  |
      | Home Delivery |
    And User click on Proceed To Payment
    Then User enter "visa" card details
    And click on Pay now Button
    Then User navigate to thankyou page
    And  User click on myAccount drop icon
    Then customer click on sign out item from drop down


    @Auth
    Examples:
      | email                        | password     |
      | munagala.suresh689@gmail.com | Wtpmjgda@689 |



  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page


  Scenario Outline: Verify functional flows in checkout page Click and Collect-Credit/Debit Card-Register User
    Then User click on login link and navigate to login page
    Then customer enter valid "<email>" and password "<password>"
    Then User landed to registered home page
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType    |
      | click & Collect |
    Then User search and select "cairo" city
    And User enter "contact" details
    And User click on Proceed To Payment
    Then User enter "visa" card details
    And click on Pay now Button
    Then User navigate to thankyou page
    And  User click on myAccount drop icon
    Then customer click on sign out item from drop down


    @Auth
    Examples:
      | email                        | password     |
      | munagala.suresh689@gmail.com | Wtpmjgda@689 |

  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page


  Scenario Outline: Verify functional flows in checkout page Home Delivery-Cash on Delivery-Register User
    Then User click on login link and navigate to login page
    Then customer enter valid "<email>" and password "<password>"
    Then User landed to registered home page
    And  User click on myAccount drop icon
    Then user click on myAccount section from dropdown icon
    Then User click on address book section in my account page
    Then click on delete address from address book in Address Page
    And confirm deletion of address from address book in my account
    Then user click on add address from add address page
    And user add new address details in add address page
    Then user click on save button for add address
    And Verify saved address details in address list in myAccount
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType    |
      | Home Delivery   |
    And User click on Proceed To Payment
    Then User choose Cash on Delivery
    And click on Pay now Button
    Then User navigate to thankyou page
    And  User click on myAccount drop icon
    Then customer click on sign out item from drop down


    @Auth
    Examples:
      | email                        | password     |
      | munagala.suresh689@gmail.com | Wtpmjgda@689 |


  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page


  Scenario Outline: Verify Cash On Delivery visible in Disabled mode in Click & Collect-Registered User
    Then User click on login link and navigate to login page
    Then customer enter valid "<email>" and password "<password>"
    Then User landed to registered home page
    Then User click on basket icon
    And  Verify user landed to cart page
    Then User click on checkout
    And Verify product details in checkout page
    And User click delivery mode as
      | deliveryType    |
      | click & Collect |
    Then User search and select "cairo" city
    And User enter "contact" details
    And User click on Proceed To Payment
    Then Verify Cash on Delivery option disabled
    When User navigate to product detail page
    And  User click on myAccount drop icon
    Then customer click on sign out item from drop down


    @Auth
    Examples:
      | email                        | password     |
      | munagala.suresh689@gmail.com | Wtpmjgda@689 |


  Scenario: clear cache and land to browser home page
    And user clear cache and launch browser home page
  No newline at end of file
