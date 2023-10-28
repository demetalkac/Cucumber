package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefinitions {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtil excelUtil;

    //    will store excel data
    List<Map<String,String>> allTestData;

    //    1. Create a login method
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        try {
            blueRentalHomePage.homePageLoginLink.click();
        } catch (Exception e) {
        }
        try {
            ReusableMethods.waitFor(1);
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
        ReusableMethods.waitFor(3);
    }

    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) throws IOException { //sheet is representing "customer_info" in feature file
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx"; // path of the excel sheet(content root)
        String sheetName = sheet;
        excelUtil = new ExcelUtil(path, sheetName);
//        getDataList() method returns all excel data
//        we stored that data in allTestData variable
        allTestData = excelUtil.getDataList();
//        System.out.println(allTestData);
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));
//        USING LOOP GET THE VALUES FROM THE MAP AND SEND INTO THE UI
        for (Map<String, String> eachData : allTestData) {
//            Takes us to the login page
            login();
            blueRentalLoginPage.userName.sendKeys(eachData.get("username")); // eachData is a Map
//                                                                             // with get() method send key and get value
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);

//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(eachData.get("username"));

        }
    }

    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshot");

    }
}

/*
User Story: Test login functionality of the blue rental car app with 3 credentials
We stored all of the test data in excel
1. Then created feature file
@excel_customer_login
Feature: excel_login_feature
  Scenario: TC_customer_credentials_test

    Given user tries to login as "customer"
    Then verify login is successful
    Then capture the screenshot
    Then close the application
2. Generated step definitions and wrote Java code
 BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtil excelUtil;

    //    will store excel data
    List<Map<String,String>> allTestData;

    //    1. Create a login method
    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        ReusableMethods.waitFor(3);
        try {
            blueRentalHomePage.homePageLoginLink.click();
        } catch (Exception e) {
        }
        try {
            ReusableMethods.waitFor(1);
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.logoutLink.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            blueRentalHomePage.homePageLoginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {
        }
        ReusableMethods.waitFor(3);
    }

    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String string) throws IOException {
        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx"; // path of the excel sheet(content root)
        String sheetName = "customer_info";
        excelUtil = new ExcelUtil(path, sheetName);
//        getDataList() method returns all excel data
//        we stored that data in allTestData variable
        allTestData = excelUtil.getDataList();
//        System.out.println(allTestData);
//        System.out.println(excelUtils.getColumnsNames());
//        System.out.println(excelUtils.getCellData(2,1));
//        USING LOOP GET THE VALUES FROM THE MAP AND SEND INTO THE UI
        for (Map<String, String> eachData : allTestData) {
//            Takes us to the login page
            login();
            blueRentalLoginPage.userName.sendKeys(eachData.get("username")); // eachData is a Map
//                                                                             // with get() method send key and get value
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.password.sendKeys(eachData.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);

//            Verify if login is successful
//            IF USER ID IS DISPLAYED THEN LOGIN IS SUCCESSFUL
            Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
            ReusableMethods.getScreenshot(eachData.get("username"));

        }
    }

    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("screenshot");

    }}

3. NOTE: We copied existing java code from testNG
   Because Java sections are the same
   We also copied some of the page objects from testNG project
   Because we are using POM and same website

 */


