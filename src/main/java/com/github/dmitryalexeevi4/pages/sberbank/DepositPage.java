package com.github.dmitryalexeevi4.pages.sberbank;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DepositPage extends Page {
    public SelenideElement moreButton = $(By.cssSelector(".offered-products__button-wrap_more"));

    public ElementsCollection getCheckboxes() {
        $(By.cssSelector("tabs-container__tab-panel-active iframe")).is(exist);
        getWebDriver().switchTo().frame(0);
        return $$(By.cssSelector("label.kitt-checkbox-group__checkbox"));
    }

    public ElementsCollection getTabs() {
        return $$(".offered-products__item");
    }

    public SelenideElement getCheckbox(String checkbox) {
        return $(By.xpath("//div[.= '" + checkbox + "']/preceding-sibling::input"));
    }

    public DepositPage clickCheckboxes(List<String> checkboxes) {
        for (int index = 0; index < checkboxes.size(); index++) {
            $(By.xpath("//div[.= '" + checkboxes.get(index) + "']/preceding-sibling::div[@class='kitt-checkbox__control']")).click();
        }
        return this;
    }
}
