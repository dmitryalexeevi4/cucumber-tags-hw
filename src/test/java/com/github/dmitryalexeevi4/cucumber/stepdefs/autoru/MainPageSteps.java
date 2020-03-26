package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import io.cucumber.java.ru.*;

import static com.github.dmitryalexeevi4.pages.autoru.MainPage.*;

public class MainPageSteps {
    static int advCountFromMainPage = 0;

    @Затем("запоминаем количество автомобилей марки {string}")
    public void saveAdvCount(String carMark) {
        advCountFromMainPage = getMainPage().getAdvCount(carMark);
    }

    @Затем("пользователь переходит на страницу с объявлениями по марке {string}")
    public void enterCarsPage(String carMark) {
        getMainPage().clickAdvButton(carMark);
    }
}
