package com.alexlis.helpers;

import com.alexlis.config.CredentialsConfig;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    static void beforeAll() {
        String browserURL = "selenoid.autotests.cloud/wd/hub";
        String browserVersion = System.getProperty("browserVersion");
        String login = credentials.login();
        String password = credentials.password();
        String browserSize = System.getProperty("browserSize", "3280x2840");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;

        String remote = System.getProperty("remote", "https://" + login + ":" + password + "@" + browserURL);

        Configuration.remote = remote;
    }

    @AfterEach
    public void tearDown() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}