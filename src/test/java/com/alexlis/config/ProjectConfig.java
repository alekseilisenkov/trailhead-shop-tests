package com.alexlis.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("91.0")
    String browserVersion();
    @DefaultValue("3840x2400")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}
