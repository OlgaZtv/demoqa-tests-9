package guru.qa.tests;


import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class StudentRegTestPageO extends TestBase {


    @Test
    public void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Olga")
                .typeLastName("Ztv");
        $("[id=userEmail]").setValue("test@test.ru");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567899");
        registrationPage.calendar.setDate("31", "August", "1988");
        $("#subjectsInput").sendKeys("Arts");
        $("#subjectsInput").pressEnter();
        $(byText("Reading")).scrollTo().click();
        File image = new File("src/test/resources/lama.jpg");
        $("[id=uploadPicture]").uploadFile(image);
        $("[id=currentAddress]").setValue("Test test test");
        $("#state").scrollTo().click();
        $("#state").find(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("[id=submit]").click();

        $("#example-modal-sizes-title-lg").should(have(text("Thanks for submitting the form")));
        registrationPage.checkResultsValue("Student Name", "Olga Ztv")
                .checkResultsValue("Student Email", "test@test.ru")
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", "1234567899")
                .checkResultsValue("Date of Birth", "31 August,1988")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "lama.jpg")
                .checkResultsValue("Address", "Test test test")
                .checkResultsValue("State and City", "Haryana Karnal");

        $("#closeLargeModal").scrollTo().click();

        $("#modal-dialog").shouldNotBe(visible);
        $("#practice-form-wrapper").isDisplayed();

    }

}



