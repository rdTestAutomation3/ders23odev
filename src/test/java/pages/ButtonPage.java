package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class ButtonPage extends BasePage{

    // Sayfadaki gerekli elementleri tanımlıyoruz
    public SelenideElement buttonsOption = $("#item-4"); // "Buttons" menüsünü seçiyoruz
    public SelenideElement clickMeButton = $("div .mt-4 > button:not([id^='r'])");
    // "Click Me" butonunu seçiyoruz
    public SelenideElement message = $("#dynamicClickMessage"); // Mesajı buluyoruz

    public ButtonPage(String pageUrl) {

        super(pageUrl);
    }

    // Butona tıklamak ve mesajı kontrol etmek için bir metot
    public void clickButtonAndCheckMessage() {
        buttonsOption.click(); // "Buttons" menüsüne tıklıyoruz
        clickMeButton.click(); // "Click Me" butonuna tıklıyoruz
    }

    // Mesajın doğru olduğunu kontrol etmek için bir metot
    public boolean isMessageDisplayed() {
        return message.isDisplayed(); // Mesajın görünür olduğunu kontrol ediyoruz
    }
}
