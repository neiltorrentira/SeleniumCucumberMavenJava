
@Smoke @Regression
Feature: Browse Google
  I want to browse and search Google in my feature file

Scenario: Open, Search Google scenario
    Given Open Google
    When User enter search text
    Then User validate search text is present