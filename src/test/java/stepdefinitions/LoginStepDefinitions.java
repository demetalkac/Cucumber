package stepdefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    @Given("user enters customer_email and customer_password")
    public void user_enters_customer_email_and_customer_password(DataTable credentials) {
//        1. GET DATA AS LIST OF STRING
//        List<String> customerData = credentials.row(1); // row index start at 0
//        System.out.println(customerData.get(0));
//        System.out.println(customerData.get(1));
//        System.out.println(credentials.row(1).get(0));//2nd row 1st column
//        System.out.println(credentials.row(1).get(1));//2nd row 2nd column
//        blueRentalLoginPage.userName.sendKeys(customerData.get(0));
//        blueRentalLoginPage.password.sendKeys(customerData.get(1));
//        blueRentalLoginPage.loginButton.click();


//      2.GET DATA AS <LIST<MAP<STRING, STRING>>
        List<Map<String, String>> customerData = credentials.asMaps(String.class, String.class);

        //        System.out.println(customerData);
        for (Map<String,String> each : customerData){
            blueRentalLoginPage.userName.sendKeys(each.get("username"));
            blueRentalLoginPage.password.sendKeys(each.get("password"));
            blueRentalLoginPage.loginButton.click();
        }
    }

    @Then("verify the application login is successful")
    public void verify_the_application_login_is_successful() {
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
    }

    @Then("verify the next page url contains login keyword")
    public void verify_the_next_page_url_contains_login_keyword() {
        ReusableMethods.waitFor(5);
//        BELOW ASSERTION FAILS
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
    // We do this on purpose, so that the test case fails, and we get the screenshot with the help of Hook (after method)


}


