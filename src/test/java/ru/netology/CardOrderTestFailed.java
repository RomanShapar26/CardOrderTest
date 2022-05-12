package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTestFailed {

    @BeforeEach
    public void openPage() {
        open("http://localhost:9999/");
    }


    @Test
    public void shouldShowErrorInvalidNumberFieldEmpty() {
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldShowErrorInvalidName() {
        $("[data-test-id=name] input").setValue("Ivanov Ivan");
        $("[data-test-id=phone] input").setValue("+1236547895");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldShowErrorInvalidNumberTelephoneField() {
        $("[data-test-id=name] input").setValue("Игорь Игорев");
        $("[data-test-id=phone] input").setValue("+1549646236547895");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldShowErrorNoSymbol() {
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $("[type=button]").click();
        $(".input_type_text .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }
}
