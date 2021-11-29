package guru.qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateComponent {

    private final SelenideElement stateInput = $("#state");

    public void setState() {
        stateInput.scrollTo().click();
        stateInput.find(byText("Haryana")).click();
    }
}

