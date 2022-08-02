package com.alexlis.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class Tests {

    @BeforeAll
    public static void config() {
        Configuration.browserSize = "3840x2400";
        Configuration.baseUrl = "https://www.34play.me/";
        Configuration.screenshots = true;
    }


    @DisplayName("Проверка навигационного меню на главной странице")
    @Test
    void mainPageCheck() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Проверка заголовков", () ->
                $(".nav").shouldHave(text("Мужчины"), text("Женщины"), text("Аксессуары")));
    }

    @DisplayName("Проверка содержания раздела Мужчины")
    @Test
    void manListPageCheck() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());


        $$(".nav").findBy(text("Мужчины")).$("a").hover();

        $(".subnav__list").shouldHave(text("Футболки"), text("Толстовки"), text("Брюки"));

    }

    @DisplayName("Авторизация в личном кабинете")
    @Test
    void oauthValidation() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Клик на кнопку ВХОД", () ->
                $("[data-action=userLogin]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Ввод данных в форму авторизации", () -> {
            $("[name=login]").setValue("alexlisenkov92@mail.ru");
            $("[name=password]").setValue("Jvcr1234");
            $(".submit").click();
        });

        step("Переход в личный кабинет", () -> {
            $(".lk").hover();
            $(byText("Личные данные")).click();
        });

        step("Проверка данных в ЛК", () ->
                $(".account__data-container").shouldHave(text("Лисенков Алексей"), text("+7(999)460-12-20")));
    }

    @DisplayName("Проверка ввода невалидного логина")
    @Test
    void insertNegativeNameAuthCheck() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Клик на кнопку ВХОД", () ->
                $("[data-action=userLogin]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Ввод данных в форму авторизации", () -> {
            $("[name=login]").setValue("simple@mail.ru");
            $("[name=password]").setValue("Jvcr1234");
            $(".submit").click();
        });

        step("Проверка ошибки авторизации", () ->
                $("._popup_auth").shouldHave(text("Логин/пароль не верен")));
    }

    @DisplayName("Проверка ввода невалидного пароля")
    @Test
    void insertNegativePasswordAuthCheck() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Клик на кнопку ВХОД", () ->
                $("[data-action=userLogin]").click());

        step("Ввод данных в форму авторизации", () -> {
            $("[name=login]").setValue("alexlisenkov92@mail.ru");
            $("[name=password]").setValue("1234");
            $(".submit").click();
        });

        step("Проверка ошибки авторизации", () ->
                $("._popup_auth").shouldHave(text("Логин/пароль не верен")));
    }

    @DisplayName("Добавление товара в корзину")
    @Test
    void addItemToCart() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Переход в каталог", () -> {
            $(byText("Мужчины")).click();
            $(byText("Одежда")).click();
        });

        step("Добавление товара", () -> {
            $$(".goodsContainer").first().click();
            $(byText("Быстрый просмотр")).click();
            $("[data-size=L]").click();
            $(byText("Положить в корзину")).click();
        });

        step("Переход в корзину", () -> {
            $(".link").click();
            sleep(2000);
        });

        step("Проверка размера и артикула товара в корзине", () -> {
            $(".table-size").has(text("L"));
            $(".art").shouldHave(text("MHD096F-NOPRI1-GR21"));
        });
    }

    @DisplayName("Удаление товара из корзины")
    @Test
    void deleteItemFromCart() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Выбор категории товара", () ->
                $(".banners__item--desktop-1").click());

        step("Добавление товара", () -> {
            $$(".goodsContainer").last().click();
            $(byText("Быстрый просмотр")).click();
            $("[data-size=M]").click();
            $(byText("Положить в корзину")).click();
        });

        step("Переход в корзину", () -> {
            $(".link").click();
            sleep(2000);
        });

        step("Удаление товара из корзины", () -> {
            $$(".goodInCart").findBy(text("6 499")).$("._del_row").click();
            sleep(5000);
            $(byText("Удалить")).click();
        });

        step("Проверка корзины", () ->
                $(".ifempty").shouldHave(text("В корзине ничего нет"))
        );
    }

    @DisplayName("Проверка нижних колонтитулов на главной странице")
    @Test
    void checkFootersMainPage() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Проверка колонтитулов", () ->
                $(".main-footer__text").scrollIntoView(true).shouldHave(text("Официальный интернет магазин 34 PLAY")));
    }

    @DisplayName("Проверка функционала фильтрации товара")
    @Test
    void checkFiltersTest() {
        step("Открыть страницу", () ->
                open("https://www.34play.me/"));

        step("Подтверждение 18 лет", () ->
                $("[data-action=confirm]").click());

        step("Подтверждение региона", () ->
                $(byText("Да, верно")).click());

        step("Выбор категории товара", () ->
                $(".banners__item--desktop-1").click());

        step("Выбор фильтров", () -> {
            $(byText("Мужское")).click();
            $("#cost_max").setValue("4299").pressEnter();
        });

        step("Проверка наличия элемента подходящего под параметры фильтрации", () ->
                $x("//a[contains(@href, '/good/tolstovka-trailhead-uhd001-nopri1-gr21-gr')]").shouldBe(visible)
        );

        step("Проверка отсутствия товаров с невалидной ценой в списке", () ->
                $(".product").shouldNotHave(text("6 499"))
        );
    }
}
