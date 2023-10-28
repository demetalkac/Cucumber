Feature: Room validation

  @room_db_01
  Scenario: Validate Room by Room Number
    Given user connect to the application database
    When get all "room_number" as a list from "room"
    Then verify roomList contains "95864158"
    And close the connection