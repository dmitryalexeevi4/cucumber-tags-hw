package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import com.github.dmitryalexeevi4.cucumber.stepdefs.StepMethods;
import com.github.dmitryalexeevi4.pages.autoru.CarsPage;
import com.github.dmitryalexeevi4.pages.autoru.MainPage;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class MainPageSteps extends StepMethods {
    MainPage mainPage = new MainPage();
    CarsPage carsPage = new CarsPage();
    int expectedAdvCount = 0, actualAdvCount = 0;

    @Дано("пользователь входит на сайт {string}")
    public void openLink(String link) {
        open(link);
    }

    @Тогда("открывается страница, в названии которой содержится текст {string}")
    public void titleCheck(String prefix) {
        Assert.assertTrue(title().startsWith(prefix));
    }

    @Затем("запоминаем количество автомобилей марки {string}")
    public void saveAdvCount(String carMark) {
        expectedAdvCount = mainPage.getAdvCount(carMark);
    }

    @Затем("пользователь переходит на страницу с объявлениями по марке {string}")
    public void enterCarsPage(String carMark) {
        mainPage.clickAdvButton(carMark);
    }

    @Тогда("открывается страница, в названии которой содержится текст - {string}")
    public void anotherTitleCheck(String buyCarMark) {
        Assert.assertTrue(title().startsWith(buyCarMark));
        actualAdvCount = carsPage.getAdvCount();
        Assert.assertEquals(actualAdvCount, expectedAdvCount);
    }
}
