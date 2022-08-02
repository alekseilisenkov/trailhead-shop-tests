package com.alexlis.tests;

import com.alexlis.pages.PageObjects;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;


@Story("Login tests")
public class LoginTests extends TestBase {

    //    @BeforeAll
//    static void configureBaseUrl() {
//        RestAssured.baseURI = App.config.apiUrl();
//        Configuration.baseUrl = App.config.webUrl();
//
//        login = App.config.userLogin();
//        password = App.config.userPassword();
//    }
    PageObjects pageObjects = new PageObjects();


    //Регистрация, есть проблемы с капчей
    @Test
    void registrationTest(){

        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();

        $("[data-action='userRegister']").click();
        $(".recaptcha-checkbox-unchecked").hover();
        $(".recaptcha-checkbox-hover").click();
    }


    @DisplayName("Авторизация в личном кабинете")
    @Step("Авторизация с логином: {} и паролем: {}")
    @Test
    void fakerTest() {

        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow("alexlisenkov92@mail.ru", "Jvcr1234");
        pageObjects.switchToPersonalAccountPage();

        pageObjects.checkForDataInPersonalAccount("Лисенков Алексей", "+7(999)460-12-20");
    }

    @DisplayName("Авторизация в личном кабинете")
    @Step("Авторизация с логином: {} и паролем: {}")
    @Test
    void oauthValidation() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow("alexlisenkov92@mail.ru", "Jvcr1234");
        pageObjects.switchToPersonalAccountPage();

        pageObjects.checkForDataInPersonalAccount("Лисенков Алексей", "+7(999)460-12-20");
    }

    @DisplayName("Проверка ввода невалидного логина")
    @Step("Авторизация с логином: {} и паролем: {}")
    @Test
    void insertNegativeNameAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow("simple@mail.ru", "Jvcr1234");

        pageObjects.checkForAuthorizationError();
    }

    @DisplayName("Проверка ввода невалидного пароля")
    @Step("Авторизация с логином: {} и паролем: {}")
    @Test
    void insertNegativePasswordAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow("simple@mail.ru", "1234");

        pageObjects.checkForAuthorizationError();
    }
}
