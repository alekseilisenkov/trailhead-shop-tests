package com.alexlis.tests;

import com.alexlis.helpers.TestBase;
import com.alexlis.pages.PageObjects;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


@Owner("Alexey Lisenkov")
public class CheckDataTests extends TestBase {

    private PageObjects pageObjects = new PageObjects();

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @DisplayName("Проверка навигационного меню на главной странице")
    @Test
    void mainPageCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();

        pageObjects.checkHeaders();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @DisplayName("Проверка содержания раздела Мужчины")
    @Test
    void manListPageCheck() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.getManTitle();

        pageObjects.checkManTitle();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("ShoppingBag")
    @DisplayName("Добавление товара в корзину")
    @ParameterizedTest
    @Test
    void addItemToCart() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.stepToManCatalog();
        pageObjects.addFirstItemInShoppingBag();
        pageObjects.switchToShoppingBag();

        pageObjects.checkForAddedItemInShoppingBag("L");
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("ShoppingBag")
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

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @DisplayName("Проверка нижних колонтитулов на главной странице")
    @Test
    void checkFootersMainPage() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();

        pageObjects.checkForRunnigTitle();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Filters")
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
