package guru.qa.tests;


import org.junit.jupiter.api.Test;


public class StudentRegTestPageObjectHW extends TestBase {


    @Test
    public void fillFormTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName("Olga")
                .typeLastName("Ztv")
                .typeEmail("test@test.ru")
                .selectGender("Female")
                .typePhone("1234567899");
        registrationPage.calendar.setDate("31", "August", "1988");
        registrationPage.subject.setSubject("Arts");
        registrationPage.selectHobby();
        registrationPage.uploadPicture();
        registrationPage.typeAddress("Test test test");
        registrationPage.state.setState();
        registrationPage.city.setCity();
        registrationPage.clickSubmit();
        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue("Student Name", "Olga Ztv")
                .checkResultsValue("Student Email", "test@test.ru")
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", "1234567899")
                .checkResultsValue("Date of Birth", "31 August,1988")
                .checkResultsValue("Subjects", "Arts")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "lama.jpg")
                .checkResultsValue("Address", "Test test test")
                .checkResultsValue("State and City", "Haryana Karnal")
                .closeModal()
                .checkModal()
                .checkResult();
    }

}



