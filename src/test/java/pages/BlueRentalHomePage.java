package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class BlueRentalHomePage {
    public BlueRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement homePageLoginLink;

    //    @FindBy(xpath = "//*[contains(.,' Login')]")
//    public WebElement homePageLoginLink;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;
    @FindBy(xpath = "//button[text()='OK']")
    public WebElement OK;

}
