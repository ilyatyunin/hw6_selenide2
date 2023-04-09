package ru.betboom;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprisePage {
    @Test
    void shouldOpenEnterprisePage() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
    }
}