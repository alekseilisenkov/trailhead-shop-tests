package com.alexlis.pages;

import com.alexlis.domain.MenuItem;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchValue {

    public SearchValue searchQuery(MenuItem menuItem) {
        step("Добавление значения в поисковую строку", () -> {
            if (menuItem == MenuItem.CAR) {
                $("[placeholder=Поиск]").setValue(menuItem.getDescription()).pressEnter();
            } else if (menuItem == MenuItem.PLANE) {
                $("[placeholder=Поиск]").setValue(menuItem.getDescription()).pressEnter();
            } else if (menuItem == MenuItem.TRAIN) {
                $("[placeholder=Поиск]").setValue(menuItem.getDescription()).pressEnter();
            } else throw new IllegalArgumentException("Enum " + menuItem + " not supported here");
        });
        return this;
    }
}