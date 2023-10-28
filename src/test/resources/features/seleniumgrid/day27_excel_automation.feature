@excel_customer_login
Feature: excel_login_feature

  Scenario: TC_customer_credentials_test
    Given user tries to login as "customer_info"
    Then verify login is successful
    Then capture the screenshot
    Then close the application

  @admin_excel
  Scenario: TC_admin_credentials_test
    Given user tries to login as "admin_info"
    Then verify login is successful
    Then capture the screenshot
    Then close the application


# Excel Test Steps :
# I added apache.poi poi-ooxml and poi dependencies in my pom.xml file
# I have excel utils class in my Cucumber framework to run test cases with my excel sheet.
# I created my feature file. And generated step definitions. "ExcelStepDefinitions"
# In my configuration.properties file, I put the url and credentials(username, password) to login the application
# I created one more folder named TestData under resources to put the excel file in it and dragged and dropped the excel file.(smoketestdata.xlsx)
# I completed stepdefs and wrote Java codes.
#   Step Definitions
#   @Given("user tries to login as {string}")
#    public void user_tries_to_login_as(String sheet) throws IOException { //sheet is representing "customer_info" in feature file
#        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx"; // path of the excel sheet(content root)
#        String sheetName = sheet;
#        excelUtil = new ExcelUtil(path, sheetName);
#        allTestData = excelUtil.getDataList();
#//        USING LOOP GET THE VALUES FROM THE MAP AND SEND INTO THE UI
#        for (Map<String, String> eachData : allTestData) {
#//            Takes us to the login page
#            login();
#            blueRentalLoginPage.userName.sendKeys(eachData.get("username"));
#            blueRentalLoginPage.password.sendKeys(eachData.get("password"));
#            blueRentalLoginPage.loginButton.click();
#//            Verify if login is successful
#//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
#            Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
#            ReusableMethods.getScreenshot(eachData.get("username"));
#        }
#  Only difference between TestNG and Cucumber Excel test is in testNG we do nor use Gherkin language, we use @Test annotation.
#  But in Cucumber we use Gherkin language in feature file.






