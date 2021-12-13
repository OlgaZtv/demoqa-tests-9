package guru.qa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Selenide.open;

public class WebDriverUtil {
    private static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    public void openMainPage() {
        open(apiConfig.baseUrl());
    }

    public static void configure() {
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();

        if (System.getProperty("environmentBrowser").equals("selenoid")) {
            Configuration.remote = config.remoteDriverUrl();
        }
    }

}