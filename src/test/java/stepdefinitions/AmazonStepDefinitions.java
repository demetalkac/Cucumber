package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AmazonStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();
    @Given("user is on the amazon home page")
    public void user_is_on_the_amazon_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
    }
    @When("user search {string} on amazon")
    public void user_search_on_amazon(String string) {
        amazonPage.searchBox.sendKeys(string+ Keys.ENTER);
    }
    @Then("verify Results visible on the page")
    public void verify_results_visible_on_the_page() {
        Assert.assertTrue(amazonPage.resultsText.isDisplayed());
    }
}


