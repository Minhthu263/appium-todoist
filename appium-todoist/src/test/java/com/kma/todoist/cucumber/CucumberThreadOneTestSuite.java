package com.kma.todoist.cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty"},
        tags = "@parallel1 and not @ignore"
)
public class CucumberThreadOneTestSuite extends AbstractTestNGCucumberTests {
}
