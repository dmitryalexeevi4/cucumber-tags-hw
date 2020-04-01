package com.github.dmitryalexeevi4.cucumber.stepdefs;

import io.cucumber.java.ru.*;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class CommonSteps {
    @Дано("пользователь входит на сайт {string}")
    public void openLink(String link) {
        open(link);
    }

    @Тогда("открывается страница, в названии которой содержится {string}")
    public void titleCheck(String string) {
        Assert.assertTrue(title().contains(string));
    }
}
