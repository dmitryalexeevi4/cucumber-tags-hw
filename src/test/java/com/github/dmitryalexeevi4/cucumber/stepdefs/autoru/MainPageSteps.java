package com.github.dmitryalexeevi4.cucumber.stepdefs.autoru;

import io.cucumber.java.ru.*;

import static com.codeborne.selenide.Selenide.$;
import static com.github.dmitryalexeevi4.pages.autoru.MainPage.getMainPage;


public class MainPageSteps {
    static int advCountFromMainPage = 0;

    @Затем("закрываем модальное окно")
    public void closeModal() {
        $(".Modal_visible .Modal__closer").click();
    }

    @Затем("запоминаем количество автомобилей марки {word}")
    public void saveAdvCount(String carMark) {
        advCountFromMainPage = getMainPage().getAdvCount(carMark);
    }

    @Затем("пользователь переходит на страницу с объявлениями по марке {word}")
    public void enterCarsPage(String carMark) {
        getMainPage().clickAdvButton(carMark);
    }
}
