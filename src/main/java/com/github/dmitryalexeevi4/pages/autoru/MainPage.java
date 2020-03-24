package com.github.dmitryalexeevi4.pages.autoru;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public void clickAdvButton(String carMark) {
        $(By.xpath("//a/div[contains(text(),'" + carMark + "')]"))
                .shouldBe(visible)
                .click();
    }

    public int getAdvCount(String carMark) {
        return Integer.parseInt($(By.xpath("//div[.='" + carMark + "']/following::div")).getText()) / 10;
    }
}
