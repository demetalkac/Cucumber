package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class GridStepDefinitions {
    WebDriver driver;
    @Given("user is on the application_url using chrome")
    public void user_is_on_the_application_url_using_chrome() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING CHROME
//        Selenium Grid URL
        URL remoteURL = new URL("http://192.168.0.19:4444"); //import java.net.URL; 'dan import ettik
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new ChromeOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }
    @Then("verify the page title contains {string}")
    public void verify_the_page_title_contains(String string) {
        Assert.assertTrue(driver.getTitle().contains(string));
    }
    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }
    @Given("user is on the application_url using firefox")
    public void user_is_on_the_application_url_using_firefox() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING FIREFOX
//        Selenium Grid URL
        URL remoteURL = new URL("http://192.168.0.19:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new FirefoxOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }

    @Given("user is on the application_url using edge")
    public void user_is_on_the_application_url_using_edge() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING EDGE
//        Selenium Grid URL
        URL remoteURL = new URL("http://192.168.0.19:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new EdgeOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }

}
/*
RUN WITH CHROME AND FIREFOX
    WebDriver driver;
    @Given("user is on the application_url using chrome")
    public void user_is_on_the_application_url_using_chrome() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING CHROME
//        Selenium Grid URL
        URL remoteURL = new URL("http://192.168.0.14:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new ChromeOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }
    @Then("verify the page title contains {string}")
    public void verify_the_page_title_contains(String string) {
        Assert.assertTrue(driver.getTitle().contains(string));
    }
    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }
    @Given("user is on the application_url using firefox")
    public void user_is_on_the_application_url_using_firefox() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING CHROME
//        Selenium Grid URL
        URL remoteURL = new URL("http://192.168.0.14:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new FirefoxOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }
 */
/*
 WebDriver driver;
    @Given("user is on the application_url using chrome")
    public void user_is_on_the_application_url_using_chrome() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING CHROME
//        Selenium Grid URL
        URL remoteURL = new URL("http://10.0.0.27:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new ChromeOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }
    @Then("verify the page title contains {string}")
    public void verify_the_page_title_contains(String string) {
        Assert.assertTrue(driver.getTitle().contains(string));
    }
    @Then("close the remote driver")
    public void close_the_remote_driver() {
        driver.quit();
    }
    @Given("user is on the application_url using edge")
    public void user_is_on_the_application_url_using_edge() throws MalformedURLException {
//        RUNNING MY TEST CASE ON A REMOTE MACHINE(SELENIUM GRID) USING CHROME
//        Selenium Grid URL
        URL remoteURL = new URL("http://10.0.0.27:4444");
//        Create RemoteWebDriver
        driver = new RemoteWebDriver(remoteURL,new EdgeOptions());
//        Grid steps are done... Rest is the same as normal test cases
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.techproeducation.com");
    }
 */

//Download firefox driver here
//https://github.com/mozilla/geckodriver/releases/tag/v0.31.0


