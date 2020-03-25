package com.github.dmitryalexeevi4.cucumber.stepdefs;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void browserSetup() {
        Configuration.browser = "opera";
        System.setProperty("selenide.browser", "opera");
    }
}
