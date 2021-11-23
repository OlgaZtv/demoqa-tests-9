package guru.qa.tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CityComponent {

    private final SelenideElement cityInput = $("#city");

    public void setCity() {
        cityInput.click();
        cityInput.$(byText("Karnal")).click();
    }
}