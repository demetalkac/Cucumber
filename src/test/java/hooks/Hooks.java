package hooks;
import base_urls.MedunnaBaseUrl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;


public class Hooks {
    /*
    Hooks is used to run before and after each SCENARIO
    i.g. If feature file has 2 scenario, Hooks will be run 2 times. It is based on the Scenario.
    To be able to run the Hooks class, we use 'glue' tag in Runner class, put "hooks" as parameter
    By putting specific tag like @After("@browser and not @headless") we can put a condition to run the Hooks class => Conditional hooks
    When we add Hooks to our runner it will generate report automatically and plus it will take screenshot if something fails.
    Run from runner class. It will generate HTML report and screenshot under "Target -> xml-report -> default-cucumber-reports.html" => right click and open in browser
     */
    @Before //comes from cucumber.java(not JUnit)
    public void setUpScenario(){
//        System.out.println("Before Method");
    }


    //This after method will understand automatically if the scenario is passed, skipped, or failed(like Listeners in TestNG)
    @After
    public void tearDownScenario(Scenario scenario){
//        System.out.println("After Method");
        if(scenario.isFailed()){//capturing the screenshot when a scenario fails and attaching to the report
            final byte[] failedScreenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario"+scenario.getName()+"");
            Driver.closeDriver();
        }
    }

    //    This Before hooks ONLY RUNS for @smoke_test TAGGED SCENARIOS ==>> Conditional Hooks
//    @Before(value = "@smoke_tests")
    @Before("@smoke_tests")
    public void setUpSmokeScenarios(){
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }

    //This After hooks ONLY RUNS for @smoke_test TAGGED SCENARIOS
    @After("@smoke_tests")
    public void tearDownSmokeScenarios(){
        System.out.println("RUN FOR ONLY SMOKE TEST SCENARIOS");
    }

    //This will run before Api test
    @Before("@TC01_Api")
    public void beforeApi(){//This method will run before TC01_Api

        MedunnaBaseUrl.medunnaSetUp();
    }


}






/*
Hooks is just a Java class, but is a special class. It is running 'before' or especially 'after' each Scenario.
After method is usually used to capture screenshot.
Like a TestBase class.
Hooks is specific for Cucumber.
We can put the code that we want to run before and after each Scenario.
 */

/*
Why do we use Hooks class in our framework?
We use hooks class to generate the reports with screenshot.
My after method especially helpful to capture screenshot when a Scenario fails automatically.
What is in it?
It has Before and After methods. I have reports method to capture the screenshot
 */
