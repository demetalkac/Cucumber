Feature: User Validation

  @user_db_01
  Scenario: Validate user by login/username
    Given user connect to the application database
    When get all "login" as a list from "jhi_user"
    Then verify usernameList contains "incisozen"
    And close the connection

  @user_db_02
  Scenario: Validate user by login/username
    Given user connect to the application database
    When get all "email" as a list from "jhi_user"
    Then verify emailList contains "emma@watson.com"
    And close the connection
