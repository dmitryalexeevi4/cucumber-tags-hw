package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.github.dmitryalexeevi4.cucumber.stepdefs.autoru.MainPageSteps.*;
import static com.github.dmitryalexeevi4.pages.autoru.CarPage.getCarPage;

public class CarPageSteps {
    static int modelAdvCountFromCarPage = 0;
    int advCountFromCarPage = 0;

    @И("сверяем текущее количество машин с количеством машин на главной страницы")
    public void countCheck() {
        advCountFromCarPage = getCarPage().getAdvCount();
        Assert.assertEquals(advCountFromCarPage, advCountFromMainPage);
    }

    @Затем("сохраняем количество объявлений конкретной модели {word}")
    public void saveModelAdvCount(String model) {
        modelAdvCountFromCarPage = getCarPage().getModelAdvCount(model);
    }

    @Затем("пользователь переходит на страницу с объявлениями по модели {word}")
    public void enterCarModelPage(String model) {
        getCarPage().clickModelAdvButton(model);
    }
}
