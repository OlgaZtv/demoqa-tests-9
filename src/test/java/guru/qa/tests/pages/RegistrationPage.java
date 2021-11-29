package guru.qa.tests.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.tests.pages.components.CalendarComponent;
import guru.qa.tests.pages.components.CityComponent;
import guru.qa.tests.pages.components.StateComponent;
import guru.qa.tests.pages.components.SubjectComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;

public class RegistrationPage {
    private final static String RESULTS_TITLE = "Thanks for submitting the form";
    //locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("[id=firstName]");
    private final SelenideElement lastNameInput = $("[id=lastName]");
    private final SelenideElement emailInput = $("[id=userEmail]");
    private final SelenideElement resultTable = $(".table-responsive");
    private final SelenideElement phoneInput = $("#userNumber");
    private final SelenideElement resultTitle = $("#example-modal-sizes-title-lg");
    private final SelenideElement uploadPicture = $("[id=uploadPicture]");
    private final SelenideElement addressInput = $("[id=currentAddress]");
    private final SelenideElement submitButton = $("[id=submit]");
    private final SelenideElement closeModal = $("#closeLargeModal");
    private final SelenideElement modalDialog = $("#modal-dialog");
    public CalendarComponent calendar = new CalendarComponent();
    public SubjectComponent subject = new SubjectComponent();
    public StateComponent state = new StateComponent();
    public CityComponent city = new CityComponent();
    File image = new File("C:\\Users\\zatul\\IdeaProjects\\demoqa-tests-9-2\\src\\test\\resources\\lama.jpg");

    //actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public void uploadPicture() {
        uploadPicture.uploadFile(image);

    }

    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationPage closeModal() {
        closeModal.scrollTo().click();
        return this;
    }

    public RegistrationPage checkModal() {
        modalDialog.shouldNotBe(visible);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public RegistrationPage selectHobby() {
        $(byText("Reading")).scrollTo().click();
        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public void typeAddress(String value) {
        addressInput.setValue(value);
    }

    public RegistrationPage checkResultsTitle() {
        resultTitle.shouldHave(text(RESULTS_TITLE));
        return this;
    }


    public RegistrationPage checkResultsValue(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResult() {
        formTitle.isDisplayed();
        return this;
    }

}
