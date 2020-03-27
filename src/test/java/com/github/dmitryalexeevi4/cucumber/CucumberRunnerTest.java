package com.github.dmitryalexeevi4.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

@CucumberOptions(
        strict = true,
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = {"com.github.dmitryalexeevi4.cucumber.stepdefs"},
        tags = "@sberbankTest"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void init() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}
