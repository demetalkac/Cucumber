package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.MedunnaHomePage;
import pages.MedunnaRoomPage;
import utilities.ReusableMethods;

public class MedunnaRoomStepdefs {

    MedunnaHomePage medunnaHomePage = new MedunnaHomePage();
    MedunnaRoomPage medunnaRoomPage = new MedunnaRoomPage();
    @When("click on Items&Titles")
    public void clickOnItemsTitles() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.itemsAndTitles.click();
    }

    @When("click on Room option")
    public void click_on_room_option() {
        ReusableMethods.waitFor(1);
        medunnaHomePage.roomOption.click();
    }

    @When("click on Create a new room button")
    public void click_on_create_a_new_room_button() {
        medunnaRoomPage.createNewRoomButton.click();
    }

    @And("enter {string} in Room Number input")
    public void enterInRoomNumberInput(String roomNumber) {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.roomNumberInput.sendKeys(roomNumber);

    }

    @When("select Suit option from Room Type dropdown")
    public void select_suit_option_from_room_type_dropdown() {
        ReusableMethods.waitFor(1);
        new Select(medunnaRoomPage.roomTypeDropdown).selectByIndex(3);
    }

    @When("click on Status checkbox")
    public void click_on_status_checkbox() {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.statusCheckbox.click();
    }

    @And("enter {string} in Price input")
    public void enterInPriceInput(String price) {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.roomPriceInput.sendKeys(price);

    }

    @And("enter {string} in Description input")
    public void enterInDescriptionInput(String description) {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.descriptionInput.sendKeys(description);
    }

    @When("click on save button")
    public void click_on_save_button() {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.saveButton.click();
    }
    @When("click onCreated Date")
    public void click_on_created_date() {
        ReusableMethods.waitFor(1);
        medunnaRoomPage.createDate.click();
    }
    @Then("assert that room is created via {string}")
    public void assert_that_room_is_created_via(String roomNumber) {
        ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(medunnaRoomPage.firstRoomNUmber, 5);
        Assert.assertEquals(roomNumber, medunnaRoomPage.firstRoomNUmber.getText());
    }
}


