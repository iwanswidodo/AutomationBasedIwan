package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
@CucumberOptions( features = {"src/test/resources/StepDef"}, glue = {"StepDef"},
        plugin = {"pretty",
                "usage:target/usage-reports/usage.json",
                "html:target/cucumber-reports/cucumberReportHTML.html",
                "json:target/cucumber-reports/cucumberReportJson.json",
                "junit:target/cucumber-reports/cucumberReportXML.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
