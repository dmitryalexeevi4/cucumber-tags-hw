package com.github.dmitryalexeevi4.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        strict = true,
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = {"com.github.dmitryalexeevi4.cucumber.stepdefs"},
        tags = "@all"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
