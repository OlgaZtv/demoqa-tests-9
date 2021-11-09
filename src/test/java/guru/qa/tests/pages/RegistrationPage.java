package guru.qa.tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("[id=firstName]"),
            lastNameInput = $("[id=lastName]"),
    resultTable = $(".table-responsive");

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }


}
