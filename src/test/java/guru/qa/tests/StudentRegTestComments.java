package guru.qa.tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegTestComments {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1900x1000";
    }

    @Test
    public void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Olga");
        $("[id=lastName]").setValue("Ztv");
        $("[id=userEmail]").setValue("test@test.ru");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $$(".react-datepicker__day").find(text("31")).click();
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
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Olga Ztv"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567899"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("31 August,1988"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("lama.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Test test test"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").scrollTo().click();

        $("#modal-dialog").shouldNotBe(visible);
        $("#practice-form-wrapper").isDisplayed();

    }

}



