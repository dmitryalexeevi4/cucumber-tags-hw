package com.github.dmitryalexeevi4.cucumber.stepdefs.sberbank;

import com.github.dmitryalexeevi4.cucumber.stepdefs.CommonSteps;
import com.github.dmitryalexeevi4.pages.sberbank.Page;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PersonPageSteps {
    Page personPage = new Page();

    @И("закрывает куки")
    public void closeCookie() {
        $("a.cookie-warning__close").waitUntil(visible, 10000).click();
    }

    @Затем("пользователь открывает страницу {string}")
    public void openSection(String pageName) {
        personPage.moveTo("Вклады").openSection("Вклады");
        $("title").waitUntil(attribute("text", "«Сбербанк» - " + pageName), 5000);
    }
}
