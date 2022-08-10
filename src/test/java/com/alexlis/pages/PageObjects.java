package com.alexlis.pages;

import com.alexlis.pages.authPages.AuthModalForm;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class PageObjects {

    public AuthModalForm authModalForm = new AuthModalForm();

    private final String URL = "https://www.34play.me/";
    private final String ERROR_MESSAGE = "Логин/пароль не верен";
    private final String BANNER = "Официальный интернет магазин 34 PLAY";
    private final String EMPTY_BIN_TEXT = "В корзине ничего нет";

    private SelenideElement
            ageButtonYes = $("[data-action=confirm]").as("Кнопка ДА"),
            regionButtonYes = $(byText("Да, верно")),
            headersRaw = $(".nav").as("Top side bar"),
            manTitle = $$(".nav").findBy(text("Мужчины")).$("a"),
            manTitleHover = $(".subnav__list"),
            inputButton = $("[data-action=userLogin]"),
            personalAccountButton = $(".lk"),
            privateDataTabDropDown = $(byText("Личные данные")),
            personalAccountPage = $(".account__data-container"),
            oauthPopUpForm = $("._popup_auth"),
            manButton = $(byText("Мужчины")),
            wearButton = $(byText("Одежда")),
            firstItemOfHoodyCatalog = $$(".goodsContainer").first(),
            lastItemOfHoodyCatalog = $$(".goodsContainer").last(),
            fastSearchRow = $(byText("Быстрый просмотр")),
            clothingSizeLButton = $("[data-size=L]"),
            clothingSizeXLButton = $("[data-size=M]"),
            clothingSizeXXLButton = $("[data-size=XXL]"),
            putInShoppingBagButton = $(byText("Положить в корзину")),
            shoppingBagButton = $(".link"),
            clothesSize = $(".table-size"),
            vendorCodeForm = $(".art"),
            binIcon = $$(".goodInCart").findBy(text("6 499")).$("._del_row"),
            deleteButton = $(byText("Удалить")),
            emptyBinPage = $(".ifempty"),
            hoodyImage = $(".banners__item--desktop-1"),
            runningTitle = $(".main-footer__text"),
            filterGenderUnit = $(byText("Мужское")),
            filterMaxPriceInput = $("#cost_max"),
            filterResultElement = $x("//a[contains(@href, '/good/tolstovka-trailhead-uhd001-nopri1-gr21-gr')]"),
            filterResultUnit = $(".product"),
            resultIncorrectSearchPage = $(".wrapper--flex");


    public PageObjects openPage() {
        step("Открыть страницу", () ->
                open(URL));
        return this;
    }

    public void confirmAge() {
        step("Подтверждение региона", () ->
                ageButtonYes.click());
    }

    public void regionConfirm() {
        step("Подтверждение региона", () ->
                regionButtonYes.click());
    }

    public void checkHeaders() {
        step("Проверка заголовков", () ->
                headersRaw.shouldHave(text("Мужчины"), text("Женщины"), text("Аксессуары")));
    }

    public void getManTitle() {
        step("Открытие списка категорий ", () ->
                manTitle.hover());
    }

    public void checkManTitle() {
        step("Проверка списка", () ->
                manTitleHover.shouldHave(text("Футболки"), text("Толстовки"), text("Брюки")));
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

    public void checkForDataInPersonalAccount(String name, String number) {
        step("Проверка данных в ЛК", () ->
                personalAccountPage.shouldHave(text(name), text(number)));
    }

    public void checkForAuthorizationError() {
        step("Проверка ошибки авторизации", () ->
                oauthPopUpForm.shouldHave(text(ERROR_MESSAGE)));
    }

    public void stepToManCatalog() {
        step("Переход в каталог", () -> {
            manButton.click();
            wearButton.click();
        });
    }

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

    public void checkForAddedItemInShoppingBag(String size) {
        step("Проверка размера и артикула товара в корзине", () -> {
            clothesSize.has(text(size));
            vendorCodeForm.shouldHave(text("MHD096F-NOPRI1-GR21"));
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

    public void checkForEmptyBin() {
        step("Проверка корзины", () ->
                emptyBinPage.shouldHave(text(EMPTY_BIN_TEXT))
        );
    }

    public void checkForRunnigTitle() {
        step("Проверка колонтитулов", () ->
                runningTitle.scrollIntoView(true).shouldHave(text(BANNER)));
    }

    public void filterConfig(String maxPrice) {
        step("Выбор фильтров", () -> {
            filterGenderUnit.click();
            filterMaxPriceInput.setValue(maxPrice).pressEnter();
        });
    }

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
}
