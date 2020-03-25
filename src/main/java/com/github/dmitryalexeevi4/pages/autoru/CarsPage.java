package com.github.dmitryalexeevi4.pages.autoru;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CarsPage {
    private SelenideElement showButton = $(".ListingCarsFilters-module__column > button");

    private String advCount() {
        return (showButton.getText().substring(showButton.getText().indexOf('ь') + 1, showButton.getText().indexOf('п')).trim()).replaceAll(" ", "");
    }

    public int getAdvCount() {
        return Integer.parseInt(advCount()) / 10;
    }


    public int getModelAdvCount(String model) {
        return Integer.parseInt($(By.xpath("//div[@class = 'ListingPopularMMM-module__item']/a[.='" + model + "']/following::div")).getText()) / 10;
    }

    public void clickModelAdvButton(String model) {
        $(By.xpath("//a[.='" + model + "']")).waitUntil(visible, 10000).click();
    }
}
