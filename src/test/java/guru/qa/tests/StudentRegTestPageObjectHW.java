package guru.qa.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class StudentRegTestPageObjectHW extends TestBase {

    Faker faker = new Faker();


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress();

    @Test
    public void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender("Female")
                .typePhone("1234567899");
        registrationPage.calendar.setDate("31", "August", "1988");
        registrationPage.subject.setSubject("Arts");
        registrationPage.selectHobby();
        registrationPage.uploadPicture();
        registrationPage.typeAddress(streetAddress);
        registrationPage.state.setState();
        registrationPage.city.setCity();
        registrationPage.clickSubmit();
        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", "1234567899")
                .checkResultsValue("Date of Birth", "31 August,1988")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "lama.jpg")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "Haryana Karnal")
                .closeModal()
                .checkModal()
                .checkResult();
    }

}



