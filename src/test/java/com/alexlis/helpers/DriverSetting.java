package com.alexlis.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetting {

    public static void configure(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", "true");
        capabilities.setCapability("enableVideo", "true");

        String browserVersion = System.getProperty("browserVersion");
        String browserSize = System.getProperty("browserSize", "3280x2840");
        String remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        String browserName = System.getProperty("browserName", "chrome");

        String remoteUrl = System.getProperty("remoteUrl");


        Configuration.browserCapabilities = capabilities;
        Configuration.browser = browserName;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.34play.me/";




        if (System.getProperty("remote") != null) {
            Configuration.remote = remote;
        }



    }


}
