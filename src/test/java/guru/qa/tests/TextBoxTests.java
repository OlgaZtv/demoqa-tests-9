package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Some name");
        $("#userEmail").setValue("test@test.ru");
        $("#currentAddress").setValue("Some address");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();

        $("#output #name").shouldHave(Condition.text("Some name"));
        $("#output").$("#email").shouldHave(Condition.text("test@test.ru"));
        $("#output").$("#currentAddress").shouldHave(Condition.text("Some address"));
        $("#output").$("#permanentAddress").shouldHave(Condition.text("Another address"));

        /*
        $("#output").shouldHave(text("Some name"), text("aaa@aa.aa"),
                text("Some address"), text("Another address"));
*/
    }
}
