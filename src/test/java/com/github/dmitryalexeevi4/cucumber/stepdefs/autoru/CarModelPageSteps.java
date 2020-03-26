package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import com.github.dmitryalexeevi4.cucumber.stepdefs.Steps;
import io.cucumber.java.ru.Тогда;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.title;
import static com.github.dmitryalexeevi4.cucumber.stepdefs.autoru.CarPageSteps.*;
import static com.github.dmitryalexeevi4.pages.autoru.CarModelPage.getCarModelPage;

public class CarModelPageSteps extends Steps {
    int modelAdvCount = 0;

    @Тогда("открывается страница {string}")
    public void titleCheck(String modelName) {
        Assert.assertTrue(title().contains(modelName));
        modelAdvCount = getCarModelPage().getAdvCount();
        Assert.assertEquals(modelAdvCount, modelAdvCountFromCarPage);
    }
}
