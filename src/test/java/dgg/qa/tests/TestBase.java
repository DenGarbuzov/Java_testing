package dgg.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }


}
