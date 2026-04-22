@regression
Feature: Search and filter

  @searchAndFilter
  Scenario: Valid product search and filtering
    Given try to close the compatibility alert window and permissions
    When perform a product search Computadora
    And filter by Apple brand
    Then valid that filter brand Apple is applied correctly