@blue_rental
Feature: blue_rental_data_tables

  Scenario Outline: US167854_manager_login_test

    Given user is on blue rental home page
    And user click on login link
    And user enters user name "<username>"
    And user enters password "<password>"
    When click on login button
    Then verify login is successful
    Then close the application

    Examples: test_data
      | username | password |
      | sam.walker@bluerentalcars.com | c!fas_art |
      | kate.brown@bluerentalcars.com | tad1$Fas |
      | raj.khan@bluerentalcars.com | v7Hg_va^ |
      | pam.raymond@bluerentalcars.com | Nga^g6! |




#User Story : US167854_manager_login_test
#NAME:user should be able to login with manager credentials
#AC: Given user is on the home page
#When user navigates to the login page
#And enter username
#And enter password
#And click on login button
#Then verify the login is successful
#ARTIFACT:
#url : https://www.bluerentalcars.com/
#Credentials:
#{"sam.walker@bluerentalcars.com","c!fas_art"},
#{"kate.brown@bluerentalcars.com","tad1$Fas"},
#{"raj.khan@bluerentalcars.com","v7Hg_va^"},
#{“pam.raymond@bluerentalcars.com","Nga^g6!"}
#NOTE: Use scenario outline