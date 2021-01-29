@Search
Feature: Search Function on Google
  
  @ValidSearch
  Scenario: Search results displayed when user searches in search bar
    Given I am on the google search page
    When I enter something in the search bar
    And I click search
    Then I should see the results on the next page