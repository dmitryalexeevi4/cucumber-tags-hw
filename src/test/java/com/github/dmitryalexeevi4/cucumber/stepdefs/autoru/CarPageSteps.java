package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import com.github.dmitryalexeevi4.cucumber.stepdefs.Steps;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.title;
import static com.github.dmitryalexeevi4.cucumber.stepdefs.autoru.MainPageSteps.*;
import static com.github.dmitryalexeevi4.pages.autoru.CarPage.getCarPage;

public class CarPageSteps extends Steps {
    static int modelAdvCountFromCarPage = 0;
    int advCountFromCarPage = 0;

    @Тогда("открывается страница, в названии которой содержится текст - {string}")
    public void titleCheck(String buyCarMark) {
        Assert.assertTrue(title().startsWith(buyCarMark));
        advCountFromCarPage = getCarPage().getAdvCount();
        Assert.assertEquals(advCountFromCarPage, advCountFromMainPage);
    }

    @Затем("сохраняем количество объявлений конкретной модели {string}")
    public void saveModelAdvCount(String model) {
        modelAdvCountFromCarPage = getCarPage().getModelAdvCount(model);
    }

    @Затем("пользователь переходит на страницу с объявлениями по модели {string}")
    public void enterCarModelPage(String model) {
        getCarPage().clickModelAdvButton(model);
    }
}
