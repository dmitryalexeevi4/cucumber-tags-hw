package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import com.github.dmitryalexeevi4.cucumber.stepdefs.Steps;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.github.dmitryalexeevi4.pages.autoru.MainPage.*;

public class MainPageSteps extends Steps {
    static int advCountFromMainPage = 0;

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
        advCountFromMainPage = getMainPage().getAdvCount(carMark);
    }

    @Затем("пользователь переходит на страницу с объявлениями по марке {string}")
    public void enterCarsPage(String carMark) {
        getMainPage().clickAdvButton(carMark);
    }
}
