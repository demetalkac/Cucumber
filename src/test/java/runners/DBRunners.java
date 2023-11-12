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
        monochrome=true,
        features = "./src/test/resources/features/jdbc", // jbdc path ini ekledik
        glue = {"stepdefinitions"},
        dryRun = false,
        tags = "@db_read"
)
public class DBRunners {
}

//GMI Bank credentials

//https://www.gmibank.com/
//Admin
//username : CWoburn
//password : Cw192837?     Go Administration--->User Management

//Customer
//username : gino.wintheiser
//password : %B6B*q1!TH


