@data_tables_1
Feature: data_tables
  Scenario: customer_login
    Given user is on "http://www.bluerentalcars.com/login" page
    And user enters customer_email and customer_password
      | username       | password |
      | jack@gmail.com | 12345    |
    Then verify the application login is successful
    And close the application



#    It is also used for Data Driven Testing but not as common as Scenario Outline
#    Data tables are used to pass multiple test data dynamically just like Scenario Outline, and String
#    This functionality is coming from Cucumber(JUnit and TestNG does not have it)
#    To use data tables, use | | Pipes in feature file steps
#    In data table we do not have 'Examples' keyword
#    Data table can be used in any step but Examples keyword must be used at the end of the scenario
#    In data tables, we use 'Scenario' keyword instead of Scenario Outline keyword
#    Data tables return 'DataTables' object in the method
#    Scenario outline returns 'String' in the method
#    We can get data in different forms such as List<String>, List<Map<String, List<List<String, ...
#    Scenario outline automatically skip the column names , understands that the column names are not test data, start from the
#    But in data table, it is not straightforward, we put everything including first line of code in a collection and than we use data starting from the second row


#    In Regular FF steps ==>> no reusable step definitions, 1 scenario
#    Parameterizing with "" ==>> reusable step defs, pass multiple data easily, 1 scenario
#    Parameterizing with Scenario Outline ==>> #1 choice in Cucumber framework, same scenario multiple different data,
#                                               reusable step defs, pass multiple data easily
#    Parameterizing with Data tables ==>> same scenario multiple different data, reusable step defs, pass multiple data easily




