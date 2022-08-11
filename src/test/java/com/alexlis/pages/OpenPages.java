package com.alexlis.pages;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class OpenPages {

    public AuthModalForm authModalForm = new AuthModalForm();

    private final String URL = "https://www.34play.me/";

    public OpenPages openPage() {
        step("Открыть страницу", () ->
                open(URL));
        return this;
    }
}
