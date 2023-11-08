@MedunnaRoom
Feature: Medunna Room Creation

  Background: Signin Medunna
    Given user is on "https://medunna.com" page
    When click on user icon
    And click on Sign In option
    And enter "AdminTeam01" in username input
    And enter "Team01+" in password input
    And click on Remember Me check box
    And click on Sign In submit button

  Scenario Outline: Create Room
    When click on Items&Titles
    And click on Room option
    And click on Create a new room button
    And enter "<room number>" in Room Number input
    And select Suit option from Room Type dropdown
    And click on Status checkbox
    And enter "<price>" in Price input
    And enter "<Description>" in Description input
    And click on save button
    And click onCreated Date
    Then assert that room is created via "<room number>"
    Then close the application

    Examples:
      | room number | price | Description |
      | 98745632    | 456   | Room 1             |
      | 65874125    | 888   | My Resting Room    |
      | 78962583    | 962   | Good viewed        |
      | 12856985    | 371   | Need extra service |