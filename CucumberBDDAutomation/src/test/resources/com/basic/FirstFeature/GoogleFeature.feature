
@Smoke @Regression
Feature: Browse Google
  I want to browse and search Google in my feature file

Scenario: Open, Search Google scenario
    Given Open Google
    When User enter "Lebron James" search text
    Then User validate "Lebron James" search text is present
    Then User Close Browser