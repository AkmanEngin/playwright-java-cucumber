Feature: Test

@search
Scenario Outline: Searching in the main page
  Given user enters "<search_term>" into the search bar
  When user clicks on the search button
  Then user should see "<search_term>" in the top 3 results

  Examples:
    | search_term |
    | grid        |
    | keynote     |

