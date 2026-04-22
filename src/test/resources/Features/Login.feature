@regression
Feature: Login

  @login
  Scenario: Validate login successfull
    Given try to close the compatibility alert window and permissions
    When login in the app
    Then validate successfull login