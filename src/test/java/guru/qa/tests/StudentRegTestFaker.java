package guru.qa.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.tests.TestData.email;


public class StudentRegTestFaker extends TestBase {
    //String firstName = getRandomString(12);

    Faker faker = new Faker(new Locale("ru"));
//    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String streetAddress = faker.address().streetAddress();

    @Test
    public void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue("Ztv");
        $("[id=userEmail]").setValue(email);
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("8");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $$(".react-datepicker__day").find(text("31")).click();
        $("#subjectsInput").sendKeys("Arts");
        $("#subjectsInput").pressEnter();
        $(byText("Reading")).scrollTo().click();
        File image = new File("E:\\Java\\demoqa-tests-9\\src\\test\\resources\\lama.jpg");
        $("[id=uploadPicture]").uploadFile(image);
        $("[id=currentAddress]").setValue(streetAddress);
        $("#state").scrollTo().click();
        $("#state").find(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("[id=submit]").click();

        $("#example-modal-sizes-title-lg").should(have(text("Thanks for submitting the form")));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " Ztv"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567899"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("31 August,1988"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("lama.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(streetAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").scrollTo().click();

        $("#modal-dialog").shouldNotBe(visible);
        $("#practice-form-wrapper").isDisplayed();

    }

}



