package com.alexlis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckupPages extends OpenPages {

    private final String ERROR_MESSAGE = "Логин/пароль не верен";
    private final String BANNER = "Официальный интернет магазин 34 PLAY";
    private final String EMPTY_BIN_TEXT = "В корзине ничего нет";

    private SelenideElement
            filterResultElement = $x("//a[contains(@href, '/good/tolstovka-trailhead-uhd001-nopri1-gr21-gr')]"),
            filterResultUnit = $(".product"),
            resultIncorrectSearchPage = $(".wrapper--flex"),
            emptyBinPage = $(".ifempty"),
            runningTitle = $(".main-footer__text"),
            headersRaw = $(".nav").as("Top side bar"),
            manTitleHover = $(".subnav__list"),
            personalAccountPage = $(".account__data-container"),
            oauthPopUpForm = $("._popup_auth"),
            clothesSize = $(".table-size"),
            vendorCodeForm = $(".art");

    public void checkForFiltersResultElement() {
        step("Проверка наличия элемента подходящего под параметры фильтрации", () ->
                filterResultElement.shouldBe(visible)
        );
    }

    public void checkForMaxValueFiltersResult(String price) {
        step("Проверка отсутствия товаров с невалидной ценой в списке", () ->
                filterResultUnit.shouldNotHave(text(price))
        );
    }

    public void checkResultIncorrectSearchPage() {
        step("Проверка отсутствия товаров с невалидной ценой в списке", () ->
                resultIncorrectSearchPage.shouldHave(text("Возможно, Вы сможете найти то, что Вам нужно в каталоге"))
        );
    }

    public void simpleCheckTitle() {
        step("Проверка соответствия текста", () -> {
            String expectedTitle = "Интернет-магазин уличной одежды 34Play";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    public void checkForEmptyBin() {
        step("Проверка корзины", () ->
                emptyBinPage.shouldHave(text(EMPTY_BIN_TEXT))
        );
    }

    public void checkForRunnigTitle() {
        step("Проверка колонтитулов", () ->
                runningTitle.scrollIntoView(true).shouldHave(text(BANNER)));
    }

    public void checkHeaders() {
        step("Проверка заголовков", () ->
                headersRaw.shouldHave(text("Мужчины"), text("Женщины"), text("Аксессуары")));
    }

    public void checkManTitle() {
        step("Проверка списка", () ->
                manTitleHover.shouldHave(text("Футболки"), text("Толстовки"), text("Брюки")));
    }

    public void checkForDataInPersonalAccount(String name, String number) {
        step("Проверка данных в ЛК", () ->
                personalAccountPage.shouldHave(text(name), text(number)));
    }

    public void checkForAuthorizationError() {
        step("Проверка ошибки авторизации", () ->
                oauthPopUpForm.shouldHave(text(ERROR_MESSAGE)));
    }


    public void checkForAddedItemInShoppingBag(String size) {
        step("Проверка размера и артикула товара в корзине", () -> {
            clothesSize.has(text(size));
            vendorCodeForm.shouldHave(text("MHD096F-NOPRI1-GR21"));
        });
    }
}