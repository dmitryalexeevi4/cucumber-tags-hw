package com.github.dmitryalexeevi4;

import static com.codeborne.selenide.Selenide.*;

public abstract class AbstractPage {
    public String getTitle() {
        return title();
    }
}
