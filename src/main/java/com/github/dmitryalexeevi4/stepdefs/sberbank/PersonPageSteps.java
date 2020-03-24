package com.github.dmitryalexeevi4.stepdefs.sberbank;

import com.github.dmitryalexeevi4.stepdefs.StepMethods;
import com.github.dmitryalexeevi4.pages.sberbank.Page;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class PersonPageSteps extends StepMethods {
    Page personPage = new Page();

    @Дано("пользователь входит на сайт - {string}")
    public void openLink(String link) {
        open(link);
        $(By.cssSelector("a.cookie-warning__close")).click();
    }

    @Тогда("открывается страница - {string}")
    public void titleCheck(String pageName) {
        Assert.assertEquals(title(), "«Сбербанк» - " + pageName);
    }

    @Затем("пользователь открывает страницу Подбор вкладов")
    public void openSection() {
        personPage.openTab("Вклады").openSection("Вклады");
    }
}
