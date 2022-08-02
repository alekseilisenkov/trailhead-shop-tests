package com.alexlis.tests;

import com.alexlis.pages.PageObjects;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Tests extends TestBase {

    @Test
    void openPage() {
        open("https://www.34play.me/");
    }

    private PageObjects pageObjects = new PageObjects();


    @DisplayName("Проверка навигационного меню на главной странице")
    @Test
    void mainPageCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();

        pageObjects.checkHeaders();
    }

    @DisplayName("Проверка содержания раздела Мужчины")
    @Test
    void manListPageCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.getManTitle();

        pageObjects.checkManTitle();
    }

    @DisplayName("Авторизация в личном кабинете")
    @Test
    void oauthValidation() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.userAuth("alexlisenkov92@mail.ru", "Jvcr1234");
        pageObjects.switchToPersonalAccountPage();

        pageObjects.checkForDataInPersonalAccount("Лисенков Алексей", "+7(999)460-12-20");
    }

    @DisplayName("Проверка ввода невалидного логина")
    @Test
    void insertNegativeNameAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.userAuth("simple@mail.ru", "Jvcr1234");

        pageObjects.checkForAuthorizationError();
    }

    @DisplayName("Проверка ввода невалидного пароля")
    @Test
    void insertNegativePasswordAuthCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.pressInputButton();
        pageObjects.userAuth("simple@mail.ru", "1234");

        pageObjects.checkForAuthorizationError();
    }

    @DisplayName("Добавление товара в корзину")
    @Test
    void addItemToCart() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.stepToManCatalog();
        pageObjects.addFirstItemInShoppingBag();
        pageObjects.switchToShoppingBag();

        pageObjects.checkForAddedItemInShoppingBag();
    }

    @DisplayName("Удаление товара из корзины")
    @Test
    void deleteItemFromCart() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.switchToBannerHoodybYImage();
        pageObjects.addLastItemInShoppingBag();
        pageObjects.switchToShoppingBag();
        pageObjects.deleteAddedItemFromShoppingBag();

        pageObjects.checkForEmptyBin();
    }

    @DisplayName("Проверка нижних колонтитулов на главной странице")
    @Test
    void checkFootersMainPage() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();

        pageObjects.checkForRunnigTitle();
    }

    @DisplayName("Проверка функционала фильтрации товара")
    @Test
    void checkFiltersTest() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.switchToBannerHoodybYImage();
        pageObjects.filterConfig("4299");

        pageObjects.checkForFiltersResultElement();
        pageObjects.checkForMaxValueFiltersResult("6 499");
    }
}
