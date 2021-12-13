package guru.qa.tests;

import guru.qa.config.WebDriverUtil;
import guru.qa.helpers.Attach;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        WebDriverUtil.configure();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}