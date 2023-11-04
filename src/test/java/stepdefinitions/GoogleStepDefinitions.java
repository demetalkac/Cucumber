package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();
    @Given("user is on the google home page")
    public void user_is_on_the_google_home_page() {
//      WRITE THE JAVA CODE
        Driver.getDriver().get(ConfigReader.getProperty("google_url"));

        try{
            googlePage.popUpAccept.click();//accept pop up if visible. Catch the error and continue if not visible
        }catch(Exception e){
        }
    }

    @When("user search for iPhone")
    public void user_search_for_i_phone() {
//      WRITE THE JAVA CODE
        googlePage.searchBox.sendKeys("iPhone"+ Keys.ENTER);

    }

    @Then("verify page title contains iPhone")
    public void verify_page_title_contains_i_phone() {
//      WRITE THE JAVA CODE
        Assert.assertTrue(Driver.getDriver().getTitle().contains("iPhone"));
       // Assert.assertTrue(Driver.getDriver().getPageSource().contains("iPhone"));
        // getPageSource() sayfanın yapısını verir.Sayfaya gelip sag tıklayınca "view page source" yaptıgı seyi verir, html codlarında arar
    }

    @Then("close the application")
    public void close_the_application() {

        Driver.closeDriver();
    }

    @When("user search for TeaPot")
    public void user_search_for_tea_pot() {
        googlePage.searchBox.sendKeys("TeaPot"+ Keys.ENTER);
    }

    @Then("verify page title contains TeaPot")
    public void verify_page_title_contains_tea_pot() {
        Driver.wait(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("TeaPot"));
    }

    @When("user search for {string} on google")
    public void user_search_for_on_google(String string) {
        googlePage.searchBox.sendKeys(string+Keys.ENTER);
    }

    @Then("verify page title contains {string}")
    public void verify_page_title_contains(String string) {
        Driver.wait(2);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

}


