package guru.qa.tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SubjectComponent {
    private final SelenideElement subjectInput = $("#subjectsInput");

    public void setSubject(String key) {
        subjectInput.sendKeys(key);
        subjectInput.pressEnter();
    }
}
