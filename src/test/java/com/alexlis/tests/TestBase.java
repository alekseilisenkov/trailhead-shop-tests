package com.alexlis.tests;

import com.alexlis.helpers.AllureAttachments;
import com.alexlis.helpers.DriverSetting;
import com.alexlis.helpers.TestData;
import com.alexlis.pages.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.alexlis.helpers.AllureAttachments.attachAsText;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

@ExtendWith(AllureJunit5.class)
public class TestBase extends DriverSetting {

    OpenPages pageObjects = new OpenPages();
    ConfirmActionsPage confirmActionsPage = new ConfirmActionsPage();
    NavigationElementsPages navigationElementsPages = new NavigationElementsPages();
    ItemActionsPages itemActionsPages = new ItemActionsPages();
    CheckupPages checkupPages = new CheckupPages();
    TestData testData = new TestData();
    SearchValue searchValue = new SearchValue();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSetting.configure();
        attachAsText("BrowserRun", System.getProperty("browserName", "chrome"));
    }

    @BeforeEach
    public void setupBeforeEach() throws InterruptedException {
        if (System.getProperty("threads") != null) {
            Thread.sleep(10_000);
        }
    }

    @AfterEach
    public void tearDown() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
        step("Артефакты прогона: ");
    }
}