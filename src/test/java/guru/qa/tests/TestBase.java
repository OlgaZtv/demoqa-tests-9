package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.tests.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1900x1000";
    }

}
