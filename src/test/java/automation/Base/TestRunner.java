package automation.base;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources/FeatureFile/register.feature",
            glue = {"com.automation.tests"},
            plugin = {
                    "pretty",
                    "html:target/cucumber-reports.html",
                    "json:target/cucumber.json"
            },
           // tags = "@Smoke",
            monochrome = true,
            dryRun = false
    )
    public class TestRunner extends AbstractTestNGCucumberTests
    {
    }


