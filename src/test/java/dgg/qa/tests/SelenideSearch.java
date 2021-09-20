package dgg.qa.tests;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }


    @Test
    void shouldFindSelenideRepositoryPage(String url){
        //открыть страницу github.com
        open(url);
        //ввести в поле selenide нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажатие на линк от первого результата поиска
        $$(".repo-list li").first().$("a").click();
        //check: в заголовке встречается selenide/selenide
        $("h1").should(text("selenide / selenide"));
    }

    @Test
    void findFirstContributor(){
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors"))
                .closest("div").$("ul li").hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
    @Test
    void pfmLandingTest(){
        open("https://planetfor.me/");
        $$(".mg-lr-50").first().click();
        Selenide.switchTo().window(1);
        $$(".pfm_category").last().shouldBe(visible);
    }


}

