package com.kma.todoist.cucumber;

//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features"
//        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
//        tags = "@check"
)
public class AllTestCase extends AbstractTestNGCucumberTests {

}
