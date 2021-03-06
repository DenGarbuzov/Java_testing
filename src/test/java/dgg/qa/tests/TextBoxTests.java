package dgg.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillPracticeFormTest() {
        String firstName = "Mike";
        String lastName = "Wasovskiy";
        String userEmail = "monster@corporation.com";
        String phoneNumber = "1234567890";
        String address = "Monster town";
        String bDay = "07 May,1988";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("[for=gender-radio-1]").click();
        $("#uploadPicture").uploadFile(new File("src/storage/photo.jpg"));
        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").scrollTo().click();


        SelenideElement table = $(".table-responsive");
        table.isSelected();

        String tableSelectorIndex = ".table-responsive tbody tr";

        $(tableSelectorIndex,0).shouldHave(text(firstName + " " + lastName), text("Student Name"));
        $(tableSelectorIndex,1).shouldHave(text(userEmail), text("Student Email"));
        $(tableSelectorIndex,2).shouldHave(text("Male"), text("Gender"));
        $(tableSelectorIndex,3).shouldHave(text(phoneNumber), text("Mobile"));
        $(tableSelectorIndex,4).shouldHave(text(bDay), text("Date of Birth"));
        $(tableSelectorIndex,5).shouldHave(text("Maths"), text("Subjects"));
        $(tableSelectorIndex,6).shouldHave(text("Sports"), text("Hobbies"));
        $(tableSelectorIndex,7).shouldHave(text("photo.jpg"), text("Picture"));
        $(tableSelectorIndex,8).shouldHave(text(address), text("Address"));
        $(tableSelectorIndex,9).shouldHave(text("NCR Delhi "), text("State and City"));
    }}