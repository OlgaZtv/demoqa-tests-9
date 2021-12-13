package guru.qa.webConfig;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${environmentBrowser}.properties",
})

public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("remoteDriverUrl")
    String remoteDriverUrl();

    @Key("browserVersion")
    @DefaultValue("96.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();
}
