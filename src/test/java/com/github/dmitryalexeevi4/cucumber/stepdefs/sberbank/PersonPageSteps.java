package com.github.dmitryalexeevi4.cucumber.stepdefs.sberbank;

import com.github.dmitryalexeevi4.cucumber.stepdefs.Steps;
import com.github.dmitryalexeevi4.pages.sberbank.Page;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PersonPageSteps extends Steps {
    Page personPage = new Page();

    @Дано("пользователь входит на сайт - {string}")
    public void openLink(String link) {
        open(link);
        //$(By.cssSelector("a.cookie-warning__close")).waitUntil(visible, 10000).click();
    }

    @Тогда("открывается страница - {string}")
    public void titleCheck(String pageName) {
        Assert.assertEquals(title(), "«Сбербанк» - " + pageName);
    }

    @Затем("пользователь открывает страницу {string}")
    public void openSection(String pageName) {
        personPage.moveTo("Вклады").openSection("Вклады");
        $("title").shouldHave(attribute("text", "«Сбербанк» - " + pageName));
    }
}
