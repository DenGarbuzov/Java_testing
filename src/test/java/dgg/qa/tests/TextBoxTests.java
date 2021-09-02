package dgg.qa.tests;

import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.SelenideElement;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


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
//        String bDay = "07 May 1901";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(phoneNumber);
//        $("#dateOfBirthInput").click();
//        $("#dateOfBirthInput").execute(pickDate(bDay));
//                sendKeys((Keys.CONTROL + "a"));
//        $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
//                sendKeys("u'\\ue009'" + "u'\\ue003'");
//        $("#dateOfBirthInput").setValue(bDay);
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
        $(".modal-dialog modal-lg").exists();

        SelenideElement table = $(".table-responsive");
        table.isSelected();

        table.shouldHave(text(firstName));
        table.shouldHave(text(lastName));
        table.shouldHave(text(userEmail));
        table.shouldHave(text(phoneNumber));
        table.shouldHave(text(address));

       String tableSelectorIndex = ".table-responsive tbody tr";

        $(tableSelectorIndex,0).shouldHave(text(firstName + " " + lastName));
        $(tableSelectorIndex,1).shouldHave(text(userEmail));
        $(tableSelectorIndex,2).shouldHave(text("Male"));
        $(tableSelectorIndex,3).shouldHave(text(phoneNumber));
//        $(tableSelectorIndex,4).shouldHave(text(bDay));
        $(tableSelectorIndex,5).shouldHave(text("Maths"));
        $(tableSelectorIndex,6).shouldHave(text("Sports"));
        $(tableSelectorIndex,7).shouldHave(text("photo.jpg"));
        $(tableSelectorIndex,8).shouldHave(text(address));
        $(tableSelectorIndex,9).shouldHave(text("NCR Delhi "));
    }}