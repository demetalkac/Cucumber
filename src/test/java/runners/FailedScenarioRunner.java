package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        monochrome=false,
        features = "@target/failedRerun.txt", // .txt dosya path. "@target" yazarken basına @ isaretini ekledik test'in dısında target da oldugu icin
        glue = {"stepdefinitions", "hooks"},
        dryRun = false

)
public class FailedScenarioRunner {

}

/*
This runner class is used to run only failedRerun.txt file
That file only has failed scenarios if any scenario fails
That file will be empty if no scenario fails
We do not use tag or path of the features folder
 */

/*
1. How do we run only failed scenarios?
        I have rerun plugin in the runner that generates the lines for only failed scenarios
2. If all our tests passed, do we see any scenario on the .txt file?
        No b/c rerun text file stores only failed scenario lines
3. What happens when we try to rerun the failedRunner if there is no failed scenarios
last time?
        No tests will run cause the text file is empty(it will be just skipped)
 */

/*
==>> In TestNG, we use Listeners Retry to rerun the failed test.
==>> In Cucumber, we use "Rerun plugin" in the runner. It is easier than testNG.
==>> If a test/assertion fails, this rerun plugin puts those failed steps into the rerun.txt file.
     So instead of running everything, we just run the txt file that has only failed scenario.
     In the rerun.txt file :
     Full path of the failed scenario : Feature file path -  features folder - feature file name - line number
==>> How can I run the failedRerun.txt file that has failed scenario when a test fails? Because I should run only the failed scenario.
     Answer : We should create a new runner class to run only this txt file. (FailedScenarioRunner)
              This class exactly the same as normal runner class except features : path. =>  features = "@target/failed.txt",
              We do not need tag because if we use a tag this will try to find test scenarios but in the text file we do not have a tag.
==>> If we run normal runner we run everything from the beginning, but if we run failedScenarioRunner we run only the failedRerun.txt file.


 */


