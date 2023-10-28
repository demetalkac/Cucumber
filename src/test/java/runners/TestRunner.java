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
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        dryRun = false,
        tags = "@parameterizing1"

)

public class TestRunner {

    /*
Failsafe helps test fail safely
It helps other tests run safely even if a test case fails
 */
/*
How do you do parallel testing in Cucumber framework?
Create multiple runner classes, and add tags of what do you want to run in parallel testing
and add required failsafe, surefire, cucumber reporting plugins/dependencies in your pom.xml file.
 */
/*
Did you do parallel testing in you project?
Yes I did.

How do you parallel testing?

1. Create Multiple runner : SmokeTestRunner, RegressionTestRunner, AddtocartTestRunner
These classes have different tags, so they run different test cases

2. Add required plug ins
Surefire:Runs the test cases in parallel mode. tread-count is given here
Failsafe: If test case fails, continue to run others tests safely
Cucumber reporting : used to generate extra detailed html reports

3. Run using maven commands from the terminal, CMD,…
mvn clean verify, mvn clean install
What are the required plugin for parallel?
maven failsafe(safe run even after some test failure), maven surefire(For parallel testing-thread count is in this plugin), and maven cucumber reporting(generation reports)
When did you do parallel testing?
I normally don’t do parallel testing in the sprints. But if I do regression testing, I can do parallel testing to save time.
 */

/*
Did you do parallel testing in you project?
Yes I did.
How do you parallel testing?
My current project is cucumber framework. We have pom.xml configuration for parallel testing.
I have multiple runner with specific tags for parallel testing. For example, Create reservation runner, smoke test runner, regression test runner, and add inventory runner can be run in parallel. When needed I use those runner as well.
What are the required plugin for parallel?
maven failsafe(safe run even after some test failure), maven surefire(For parallel testing-thread count is in this plugin), and maven cucumber reporting(generation reports)
When did you do parallel testing?
I normally don’t do parallel testing in the sprints. But if I do regression testing, I can do parallel testing to save time.
 */

}
