@regression
Feature: Shopping Cart

  @shoppingCart
  Scenario: Validate add products to shopping cart after login
    Given try to close the compatibility alert window and permissions
    When perform a product search Pantalla
    And select first element in list
    And add product to shopping cart without insurance
    And access to shopping cart
    And go to pay shopping cart
    Then validate is user not logged
    When close login screen
    And remove product from shopping cart
    Then validate is user not logged from shopping cart