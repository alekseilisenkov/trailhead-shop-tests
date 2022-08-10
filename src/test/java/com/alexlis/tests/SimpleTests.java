package com.alexlis.tests;

import com.alexlis.domain.MenuItem;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class SimpleTests extends TestBase {


    @Tag("Simple")
    @Story("Simple tests")
    @Feature("Positive")
    @Severity(SeverityLevel.MINOR)
    @Description("Autogenerated test")
    @EnumSource(MenuItem.class)
    @ParameterizedTest(name = "Проверка результатов поиска значения: {0}")
    void searchQueryTest(MenuItem menuItem) {
        pageObjects.openPage();
        confirmActionsPage.confirmAge();
        confirmActionsPage.regionConfirm();
        searchValue.searchQuery(menuItem);

        checkupPages.checkResultIncorrectSearchPage();
    }

    @Tag("Simple")
    @Story("Simple tests")
    @Feature("Positive")
    @Severity(SeverityLevel.MINOR)
    @Description("Autogenerated test")
    @DisplayName("Проверка заголовка страницы")
    @Test
    void titleTest() {
        pageObjects.openPage();

        checkupPages.simpleCheckTitle();
    }
}