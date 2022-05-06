package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {
    @BeforeEach
    public void openPage() {
        open("http://localhost:9999/");
    }

    // Положительные

    @Test
    public void shouldReturnValid() {
        $("[data-test-id=name] input").setValue("Артем Петров");
        $("[data-test-id=phone] input").setValue("+79862146556");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValueOneWord() {
        $("[data-test-id=name] input").setValue("Игнат");
        $("[data-test-id=phone] input").setValue("+45475675841");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldReturnValidValue() {
        $("[data-test-id=name] input").setValue("Степан Степанов");
        $("[data-test-id=phone] input").setValue("+77895478932");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
