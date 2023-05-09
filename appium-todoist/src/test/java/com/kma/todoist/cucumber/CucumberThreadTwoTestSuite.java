package com.kma.todoist.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        tags = "@parallel2 and not @ignore"
)
public class CucumberThreadTwoTestSuite extends AbstractTestNGCucumberTests {
}
