package stepdefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DataTablesPage;
import utilities.Driver;

public class DataTablesStepDefinitions {
    DataTablesPage dataTablesPage = new DataTablesPage();

    @Given("user is on {string} page")
    public void user_is_on_page(String url) {
        Driver.getDriver().get(url);
    }
    @Given("user clicks on the new button")
    public void user_clicks_on_the_new_button() {
        dataTablesPage.newButton.click();
    }
    @Given("user enters first name {string}")
    public void user_enters_first_name(String string) {
        dataTablesPage.firstName.sendKeys(string);
    }
    @Given("user enters last name {string}")
    public void user_enters_last_name(String string) {
        dataTablesPage.lastName.sendKeys(string);
    }
    @Given("user enters the position {string}")
    public void user_enters_the_position(String string) {
        dataTablesPage.position.sendKeys(string);
    }
    @Given("user enters the office {string}")
    public void user_enters_the_office(String string) {
        dataTablesPage.office.sendKeys(string);
    }
    @Given("user enters the extension {string}")
    public void user_enters_the_extension(String string) {
        dataTablesPage.extension.sendKeys(string);
    }
    @Given("user enters the start date {string}")
    public void user_enters_the_start_date(String string) {
        dataTablesPage.startDate.sendKeys(string);
    }
    @Given("user enters the salary {string}")
    public void user_enters_the_salary(String string) {
        dataTablesPage.salary.sendKeys(string);
    }
    @Given("click on create button")
    public void click_on_create_button() {
        dataTablesPage.createButton.click();
    }
    @Given("search for the first name {string}")
    public void search_for_the_first_name(String string) {
        dataTablesPage.searchBox.sendKeys(string);
    }
    @Then("verify the name field contains the first name {string}")
    public void verify_the_name_field_contains_the_first_name(String string) {
        Assert.assertTrue(dataTablesPage.nameColumn.getText().contains(string));
    }

}



