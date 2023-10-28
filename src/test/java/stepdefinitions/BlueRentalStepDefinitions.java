package stepdefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class BlueRentalStepDefinitions {

    BlueRentalLoginPage blueRentalLoginPage = new BlueRentalLoginPage();
    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();

    @Given("user is on blue rental home page")
    public void user_is_on_blue_rental_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
    }

    @Given("user click on login link")
    public void user_click_on_login_link() {

        blueRentalHomePage.homePageLoginLink.click();
    }

    @Given("user enters user name {string}")
    public void user_enters_user_name(String string) {

        blueRentalLoginPage.userName.sendKeys(string);
    }
    @Given("user enters password {string}")
    public void user_enters_password(String string) {

        blueRentalLoginPage.password.sendKeys(string);
    }
    @When("click on login button")
    public void click_on_login_button() {

        blueRentalLoginPage.loginButton.click();
    }
    @Then("verify login is successful")
    public void verify_login_is_successful() {
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
    }



}
