package com.alexlis.pages.authPages;

import com.alexlis.config.CredentialsConfig;
import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AuthModalForm {

    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    String login = credentials.login();
    String password = credentials.password();

    private SelenideElement
            loginInput = $("[name=login]"),
            passwordInput = $("[name=password]"),
            confirmAuthorizationButton = $(".submit");

    public void credentialAuth(){
        loginInput.setValue(login);
        passwordInput.setValue(password);
        confirmAuthorizationButton.click();
    }

    public void userAuthModalWindow(String login, String password) {
        step("Авторизация", () -> {
            loginInput.setValue(login);
            passwordInput.setValue(password);
            confirmAuthorizationButton.click();
        });
    }
}
