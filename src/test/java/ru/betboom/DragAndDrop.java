package ru.betboom;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    SelenideElement leftSquare = $("#column-a");
    SelenideElement rightSquare = $("#column-b");

    @Test // Не перемещается курсор - зажимается квадрат А, но курсор находится в месте, где был перед запуском теста
    @Disabled
    void replaceSquareWithAction() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        leftSquare.shouldHave(text("A"));
        rightSquare.shouldHave(text("B"));
        actions().clickAndHold(leftSquare).moveToElement(rightSquare).release().perform();
        leftSquare.shouldHave(text("B"));
        rightSquare.shouldHave(text("A"));
    }

    @Test // работает правильно
    void replaceSquareWithDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        leftSquare.shouldHave(text("A"));
        rightSquare.shouldHave(text("B"));
        leftSquare.dragAndDropTo(rightSquare);
        leftSquare.shouldHave(text("B"));
        rightSquare.shouldHave(text("A"));
    }
}
