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
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome=false,
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        dryRun = false,
        tags = "@google_search"

)

public class Runner {
}
// runner classı Main mrthod gibi ,testlerimizi calıstırmak icin kullanıyoruz
// glue = {"stepdefinitions", "hooks"},     ==>> When we have multiple data we use curly braces and comma between tags. If we have single, we only use "" double-quotes
/*
 features = "./src/test/resources/features",//PATH OF FEATURES FOLDER
 glue = "stepdefinitions", //PATH OF STEP DEFINITIONS. stepdefinitions ile ruuner classlarının bulundugu packageler aynı dosyanın altında yanı bulundukları dosya kardes o nedenle path olustururken ta bastan(./src/test...) yazmadık.
 dryRun = false //IF dryRun = true. RUN DRY. JUST GIVE ME THE MISSING STEP DEFINITIONS. DON'T RUN THE TEST CASES.
 dryRun= false when we are doing test execution. dryRun=true when we are generation missing step definitions
 dryRun = true : RUN DRY! Just give me the step definitions. Do not run test cases. It will save time.
 */

/*
@RunWith is used to run the class. Without this, Runner class will not be runnable
@CucumberOptions is used to add feature path, step definition path,tags, dryRun, report plug ins
tags : this marks which feature file to run. We add this tag in the feature files to run specific test cases.
 */

/*
When you run Runner, it will go to feature file, and start execution from top to bottom.
If there is any step matching, Java will find that matching 'step definition', and it will be executed.
If there is no match then Cucumber will generate template for us in the console.
 */

/*
To open HTML report right click / Open in / Browser / Chrome
For Cucumber and Json reports we just double-click and open in IntelliJ
 */
//    ****************burdan sonrasını notes a almadım
/*
      ***Scenario Outline:***
What is it?
It is used to run the same scenario with different data multiple times
It must be followed by an Examples keyword. Examples keyword is used to pass data
Scenario Outline is used for parameterization of the feature files
It is used to pass test data dynamically
This is very common and use ful in cucumber

     ***Cucumber reports plugins***
We can easily generate cucumber reports using report plugins in the runner
We can generate different reports such as HTML, json, and xml; but the most common one is the HTML report
 */

/*
NOTE: "rerun:target/failedRerun.txt"
This is going to generate text file if something fails
 */

