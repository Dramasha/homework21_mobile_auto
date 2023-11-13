package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IosTest extends BaseTest {
    @Test
    @Tag("ios")
    @DisplayName("Checking text input and display in UI Elements")
    void enterTextTest() {

        step("Click on button Text", () -> {
            $(id("Text Button")).click();
        });

        step("Click on field Enter a text", () -> {
            $(id("Text Input")).click();
        });

        step("Input in field 'Enter a text' text 'I believe, I can fly' and press Enter", () -> {
            $(id("Text Input")).sendKeys("I believe, I can fly");
            $(id("Text Input")).pressEnter();
        });

        step("Checking the display of the result with the specified text", () -> {
            assertThat($(id("Text Output")).getText())
                    .isEqualTo("I believe, I can fly");
        });
    }
}
