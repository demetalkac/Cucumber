@data_tables
Feature: data_tables

  Scenario Outline: TC_Create_And verify the test data creation

#    This is creating a reusable step that accept url and goes to that url
    Given user is on "https://editor.datatables.net/" page
    And user clicks on the new button
    And user enters first name "<firstname>"
    And user enters last name "<lastname>"
    And user enters the position "<position>"
    And user enters the office "<office>"
    And user enters the extension "<extension>"
    And user enters the start date "<start_date>"
    And user enters the salary "<salary>"
    And click on create button
    And search for the first name "<firstname>"
    Then verify the name field contains the first name "<firstname>"

    Examples: test_data
      | firstname | lastname | position | office | extension | start_date | salary |
      | john      | smith    | tester   | NYC    | 2134      | 2023-01-23 | 80000 |
      | sam       | walten   | businessman   | LA    | 5262      | 2023-01-24 | 200000 |
      | nancy      | brown    | developer   | Dallas   | 2346      | 2023-01-25 | 85000 |
      | george      | bush    | politician   | Dallas    | 9931      | 2023-01-26 | 985000 |

    #"day25_scenario_outline2.feature, DataTablesPage"