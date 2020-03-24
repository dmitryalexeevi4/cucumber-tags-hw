package com.github.dmitryalexeevi4.stepdefs.sberbank;

import com.github.dmitryalexeevi4.stepdefs.StepMethods;
import com.github.dmitryalexeevi4.pages.sberbank.*;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DepositPagesSteps extends StepMethods {
    DepositPage depositPage = new DepositPage();

    @И("кликает на вкладку {string}")
    public void clickDepositTab(String innerTabName) {
        Assert.assertEquals(title(), "«Сбербанк» - Подбор вкладов");
        depositPage.clickInnerTab(innerTabName);
    }

    @Дано("чекбоксы")
    public void checkboxesCheck(List<String> dataTable) {
        depositPage.getCheckboxes()
                .shouldHaveSize(4)
                .shouldHave(exactTexts(dataTable));

        depositPage.getCheckbox(2)
                .shouldBe(checked);
    }

    @И("вкладки")
    public void tabsCheck(List<String> dataTable) {
        depositPage.getTabs()
                .shouldHaveSize(3)
                .shouldHave(textsInAnyOrder(dataTable));
    }

    @Когда("пользователь кликает на чекбоксы")
    public void checkboxClicking() {
        depositPage
                .clickCheckbox(0)
                .clickCheckbox(1);
    }

    @Тогда("остается одна вкладка, {string}")
    public void checkVisibleTabs(String tabName) {
        depositPage.getTabs()
                .shouldHaveSize(1)
                .shouldHave(texts(tabName));
    }

    @Затем("пользователь нажимает на кнопку Подробнее")
    public void buttonClick() {
        depositPage.moreButton.click();
    }

    @И("открывает страницу {string}")
    public void titleCheck(String pageName) {
        switchTo().window(1);
        Assert.assertEquals(title(), "«Сбербанк» - " + pageName);
        $(By.cssSelector(".product-teaser-full-width > .kit-grid h2.kit-heading")).shouldHave(text(pageName));
    }
}
