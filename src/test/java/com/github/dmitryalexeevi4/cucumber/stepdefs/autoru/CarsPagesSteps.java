package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import com.github.dmitryalexeevi4.cucumber.stepdefs.StepMethods;
import com.github.dmitryalexeevi4.pages.autoru.CarsPage;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.title;

public class CarsPagesSteps extends StepMethods {
    CarsPage carsPage = new CarsPage();
    CarsPage carModelPage = new CarsPage();
    int expectedAdvCount = 0, actualAdvCount = 0;

    @Затем("сохраняем количество объявлений конкретной модели {string}")
    public void saveModelAdvCount(String model) {
        expectedAdvCount = carsPage.getModelAdvCount(model);
    }

    @Затем("пользователь переходит на страницу с объявлениями по модели {string}")
    public void enterCarModelPage(String model) {
        carsPage.clickModelAdvButton(model);
    }

    @Тогда("открывается страница {string}")
    public void titleCheck(String modelName) {
        Assert.assertTrue(title().contains(modelName));
        actualAdvCount = carModelPage.getAdvCount();
        Assert.assertEquals(actualAdvCount, expectedAdvCount);
    }
}
