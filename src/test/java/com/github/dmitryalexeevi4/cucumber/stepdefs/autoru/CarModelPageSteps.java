package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.github.dmitryalexeevi4.cucumber.stepdefs.autoru.CarPageSteps.*;
import static com.github.dmitryalexeevi4.pages.autoru.CarModelPage.getCarModelPage;

public class CarModelPageSteps {
    int modelAdvCount = 0;

    @И("сверяем текущее количество машин с количеством машин на странице марки")
    public void countCheck() {
        modelAdvCount = getCarModelPage().getAdvCount();
        Assert.assertEquals(modelAdvCount, modelAdvCountFromCarPage);
    }
}
