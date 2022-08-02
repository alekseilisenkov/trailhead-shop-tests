package com.alexlis.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AuthModalForm {

    private SelenideElement
            loginInput = $("[name=login]"),
            passwordInput = $("[name=password]"),
            confirmAuthorizationButton = $(".submit");

    public void userAuthModalWindow(String login, String password) {
        step("Авторизация", () -> {
            loginInput.setValue(login);
            passwordInput.setValue(password);
            confirmAuthorizationButton.click();
        });
    }
}
