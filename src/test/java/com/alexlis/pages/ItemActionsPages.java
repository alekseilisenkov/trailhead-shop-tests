package com.alexlis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ItemActionsPages {

    private SelenideElement
            firstItemOfHoodyCatalog = $$(".goodsContainer").first(),
            lastItemOfHoodyCatalog = $$(".goodsContainer").last(),
            fastSearchRow = $(byText("Быстрый просмотр")),
            clothingSizeLButton = $("[data-size=L]"),
            clothingSizeXLButton = $("[data-size=M]"),
            clothingSizeXXLButton = $("[data-size=XXL]"),
            putInShoppingBagButton = $(byText("Положить в корзину")),
            shoppingBagButton = $(".link");

    public void addFirstItemInShoppingBag() {
        step("Добавление товара", () -> {
            firstItemOfHoodyCatalog.click();
            fastSearchRow.click();
            clothingSizeLButton.click();
            putInShoppingBagButton.click();
        });
    }

    public void addLastItemInShoppingBag() {
        step("Добавление товара", () -> {
            lastItemOfHoodyCatalog.click();
            fastSearchRow.click();
            clothingSizeXLButton.click();
            putInShoppingBagButton.click();
        });
    }

    public void addXxlSizeItemInShoppingBag() {
        step("Добавление товара", () -> {
            lastItemOfHoodyCatalog.click();
            fastSearchRow.click();
            clothingSizeXLButton.click();
            putInShoppingBagButton.click();
        });
    }

    public void switchToShoppingBag() {
        step("Переход в корзину", () -> {
            shoppingBagButton.click();
            sleep(2000);
        });
    }
}
