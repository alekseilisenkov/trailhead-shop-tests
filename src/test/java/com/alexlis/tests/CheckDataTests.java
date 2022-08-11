package com.alexlis.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Owner("Alexey Lisenkov")
public class CheckDataTests extends TestBase {

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка навигационного меню на главной странице")
    @Test
    void mainPageCheck() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();

        checkupPages.checkHeaders();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка содержания раздела Мужчины")
    @Test
    void manListPageCheck() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();
        navigationElementsPages.getManTitle();

        checkupPages.checkManTitle();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("ShoppingBag")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Удаление товара из корзины")
    @Test
    void deleteItemFromCart() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();
        navigationElementsPages.switchToBannerHoodybYImage();
        itemActionsPages.addFirstItemInShoppingBag();
        itemActionsPages.switchToShoppingBag();
        navigationElementsPages.deleteAddedItemFromShoppingBag();

        checkupPages.checkForEmptyBin();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("ShoppingBag")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Добавление товара в корзину")
    @Test
    void addItemToCart() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();
        navigationElementsPages.stepToManCatalog();
        itemActionsPages.addLastItemInShoppingBag();
        itemActionsPages.switchToShoppingBag();

        checkupPages.checkForAddedItemInShoppingBag("XL");
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка нижних колонтитулов на главной странице")
    @Test
    void checkFootersMainPage() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();

         checkupPages.checkForRunnigTitle();
    }

    @Tag("Main")
    @Story("Main tests")
    @Feature("Filters")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка функционала фильтрации товара")
    @Test
    void checkFiltersTest() {
        openPages.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();
        navigationElementsPages.switchToBannerHoodybYImage();
        navigationElementsPages.filterConfig("4299");

        checkupPages.checkForFiltersResultElement();
        checkupPages.checkForMaxValueFiltersResult("6 499");
    }
}
