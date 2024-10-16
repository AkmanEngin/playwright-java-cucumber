Feature: Test

  Background:
    Given user is on the home page

  @home
  Scenario: Verify page is opened
    Then user should be able to see title "ISO New England"
