package com.alexlis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class NavigationElementsPages {

    private SelenideElement
            manTitle = $$(".nav").findBy(text("Мужчины")).$("a"),
            inputButton = $("[data-action=userLogin]"),
            personalAccountButton = $(".lk"),
            privateDataTabDropDown = $(byText("Личные данные")),
            manButton = $(byText("Мужчины")),
            wearButton = $(byText("Одежда")),
            binIcon = $$(".goodInCart").findBy(text("6 499")).$("._del_row"),
            deleteButton = $(byText("Удалить")),
            hoodyImage = $(".banners__item--desktop-1"),
            filterGenderUnit = $(byText("Мужское")),
            filterMaxPriceInput = $("#cost_max");

    public void getManTitle() {
        step("Открытие списка категорий ", () ->
                manTitle.hover());
    }

    public void pressInputButton() {
        step("Клик на кнопку ВХОД", () ->
                inputButton.click());
    }

    public void switchToPersonalAccountPage() {
        step("Переход в личный кабинет", () -> {
            personalAccountButton.hover();
            privateDataTabDropDown.click();
        });
    }

    public void stepToManCatalog() {
        step("Переход в каталог", () -> {
            manButton.click();
            wearButton.click();
        });
    }

    public void switchToBannerHoodybYImage() {
        step("Выбор категории товара", () ->
                hoodyImage.click());
    }

    public void deleteAddedItemFromShoppingBag() {
        step("Удаление товара из корзины", () -> {
            binIcon.click();
            sleep(5000);
            deleteButton.click();
        });
    }

    public void filterConfig(String maxPrice) {
        step("Выбор фильтров", () -> {
            filterGenderUnit.click();
            filterMaxPriceInput.setValue(maxPrice).pressEnter();
        });
    }
}
