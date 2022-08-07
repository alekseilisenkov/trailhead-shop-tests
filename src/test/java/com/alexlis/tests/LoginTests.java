package com.alexlis.tests;

import com.alexlis.domain.MenuItem;
import com.alexlis.helpers.TestBase;
import com.alexlis.helpers.TestData;
import com.alexlis.pages.PageObjects;

import com.alexlis.utils.RandomUtils;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LoginTests extends TestBase {

    TestData testData = new TestData();
    PageObjects pageObjects = new PageObjects();

    @Tag("Auth")
    @Story("Auth tests")
    @Feature("Positive")
    @DisplayName("Авторизация в личном кабинете с личными данными")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void oauthValidation() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.credentialAuth();
        pageObjects.switchToPersonalAccountPage();

        pageObjects.checkForDataInPersonalAccount("Лисенков Алексей", "+7(999)460-12-20");
    }

    @Tag("Auth")
    @Story("Auth tests")
    @Feature("Negative")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(strings = {
            "simple@mail.ru",
            "difficult@mail.ru",
            "strong@mail.ru"
    })
    @ParameterizedTest(name = "Проверка ввода невалидного логина: {0}")
    void insertNegativeNameAuthCheck(String email) {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow(email, "Jvcr1234");

        pageObjects.checkForAuthorizationError();
    }

    @Tag("Auth")
    @Story("Auth tests")
    @Feature("Negative")
    @Severity(SeverityLevel.BLOCKER)
    @CsvSource({
            "simple@mail.ru, 123",
            "simple@mail.ru, 1234",
            "simple@mail.ru, 12345",
    })
    @ParameterizedTest(name = "Проверка ввода логина {0} и невалидного пароля: {1}")
    void insertNegativePasswordAuthCheck(String email, String password) {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow(email, password);

        pageObjects.checkForAuthorizationError();
    }

    @Tag("Auth")
    @Story("Auth tests")
    @Feature("Negative")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ввода рандомного невалидного логина и пароля")
    @Test
    void insertRandomDataInAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow(RandomUtils.getRandomEmail(), RandomUtils.getRandomString(5));

        pageObjects.checkForAuthorizationError();
    }

    @Tag("Auth")
    @Story("Auth tests")
    @Feature("Negative")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка ввода рандомного невалидного логина и пароля")
    @Test
    void insertFakerDataInAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.authModalForm.userAuthModalWindow(testData.getEmail(), testData.getPassword());

        pageObjects.checkForAuthorizationError();
    }
}