package com.alexlis.tests;

import com.alexlis.config.Project;
import com.alexlis.helpers.AllureAttachments;
import com.alexlis.helpers.DriverUtils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;


@ExtendWith({AllureJunit5.class})
public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.34play.me/";
        Configuration.screenshots = true;

//        String browserURL = System.getProperty("url", credentials.browserURL());
//        String login = local.properties.login();
//        String password = credentials.password();
        String browserVersion = System.getProperty("browserVersion");
        String browserSize = System.getProperty("browserSize", "3840x2400");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
//        Configuration.remote = format("https://%s:%s@%s", login, password, browserURL);
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
