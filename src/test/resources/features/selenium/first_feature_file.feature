@google_search
Feature: first feature file
  Background: user_goes_to_google_page
    Given user is on the google home page

  @iphone_search
  Scenario: TC_01_iphone_search
    When user search for iPhone
    Then verify page title contains iPhone
    Then close the application

  @teapot_search
  Scenario: TC_02_teapot_search
    When user search for TeaPot
    Then verify page title contains TeaPot
    Then close the application


#  Feature file is used to create test cases.
#  All feature files must begin with "Feature:" keyword
#  Feature : Declare the file is a feature file. Mandatory. There can be ONLY one Feature: keyword
#  Scenario(test case) : To create test case. In a feature file there may be more than one "Scenario:"
#  Test case icin her bir adım Given,When, And, Then, But, * kelimelerinden biriyle baslamalıdır.
#  Runner : To run the feature files.
#  Background : Used to run before each scenario. This is used for repeated pre-conditions.
#  CUCUMBER STEPS
#  1. create feature file and test scenarios
#  2. run the feature file and generate step definitions. dryRun=true
#  3. use the step definitions to complete the Java code
#  4. dryRun=false to execute test cases

#     QUESTIONS:
#  1. Does spelling important in FF and Step defs? YES
#  2. Does order of steps in Feature file matters? YES
#   Because tests are run from TOP to BOTTOM in the feature file
#  3. Does order of step definitions on step definitions folder matters? NO
#   Because the tests run based of the steps NOT BASED ON THE STEP DEFINITIONS