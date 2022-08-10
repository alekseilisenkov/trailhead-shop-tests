package com.alexlis.tests;

import com.alexlis.pages.PageObjects;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Owner("Alexey Lisenkov")
public class CheckDataTests extends TestBase {

    private PageObjects pageObjects = new PageObjects();

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка навигационного меню на главной странице")
    @Test
    void mainPageCheck() {
        pageObjects
                .openPage()
                .confirmAge();
        pageObjects.regionConfirm();

        pageObjects.checkHeaders();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
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
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление товара из корзины")
    @Test
    void deleteItemFromCart() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.switchToBannerHoodybYImage();
        pageObjects.addXxlSizeItemInShoppingBag();
        pageObjects.switchToShoppingBag();
        pageObjects.deleteAddedItemFromShoppingBag();

        pageObjects.checkForEmptyBin();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("ShoppingBag")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавление товара в корзину")
    @Test
    void addItemToCart() {
        pageObjects.openPage();
        pageObjects.confirmAge();
        pageObjects.regionConfirm();
        pageObjects.stepToManCatalog();
        pageObjects.addXxlSizeItemInShoppingBag();
        pageObjects.switchToShoppingBag();

        pageObjects.checkForAddedItemInShoppingBag("XXL");
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
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
    @Severity(SeverityLevel.CRITICAL)
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
