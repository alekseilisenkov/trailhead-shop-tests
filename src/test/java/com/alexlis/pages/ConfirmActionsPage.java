package com.alexlis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ConfirmActionsPage {

    private SelenideElement
            ageButtonYes = $("[data-action=confirm]").as("Кнопка ДА"),
            regionButtonYes = $(byText("Да, верно"));

    public void confirmAge() {
        step("Подтверждение региона", () ->
                ageButtonYes.click());
    }

    public void regionConfirm() {
        step("Подтверждение региона", () ->
                regionButtonYes.click());
    }

}