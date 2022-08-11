package com.alexlis.pages;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OpenPage {

    public AuthModalForm authModalForm = new AuthModalForm();

    private final String URL = "https://www.34play.me/";

    public OpenPage openPage() {
        step("Открыть страницу", () ->
                open(URL));
        return this;
    }
}
