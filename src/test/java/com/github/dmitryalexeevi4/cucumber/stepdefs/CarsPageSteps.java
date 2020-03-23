package com.github.dmitryalexeevi4.cucumber.stepdefs;

import com.github.dmitryalexeevi4.*;
import io.cucumber.java.ru.*;
import org.testng.Assert;

public class CarsPageSteps {
    CarsPage carsPage = new CarsPage();
    CarModelPage carModelPage = new CarModelPage();
    int expectedAdvCount = 0, actualAdvCount = 0;

    @Затем("сохраняем количество объявлений конкретной модели {string}")
    public void saveModelAdvCount(String model) {
        expectedAdvCount = carsPage.getModelAdvCount(model);
    }

    @Затем("пользователь переходит на страницу с объявлениями по модели {string}")
    public void enterModelPage(String model){
        carsPage.clickModelAdvButton(model);
    }

    @Тогда("открывается страница {string}")
    public void carPageTitleCheck(String modelName) {
        Assert.assertTrue(carModelPage.getTitle().contains(modelName));
        actualAdvCount = carModelPage.getAdvCount();
        Assert.assertEquals(actualAdvCount, expectedAdvCount);
    }
}
