@regression
Feature: Explore and Sort

  @exploreAndSort
  Scenario: Valid explore department and sort products list
    Given try to close the compatibility alert window and permissions
    When access to navbar section EXPLORE
    And explore section ELECTRONIC
    And explore electronic subsection GAMING
    And explore gaming subsection PC_GAMER
    And sort by LEAST_TO_GREATEST
    Then validate that sort by pricing LEAST_TO_GREATEST is applied correctly