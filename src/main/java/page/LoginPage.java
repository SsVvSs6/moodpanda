package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String LOGIN_URL = "https://moodpanda.com/login";
    private static final SelenideElement EMAIL_INPUT = $(By.xpath("//input[@placeholder='MoodPanda registered email ']"));
    private static final SelenideElement PASSWORD_INPUT = $(By.xpath("//input[@name='password']"));
    private static final SelenideElement LOGIN_BUTTON = $(By.xpath("//button[contains(@class,'button')]"));

    public LoginPage openPage() {
        open(LOGIN_URL);
        return this;
    }

    public LoginPage enterEmail(String email) {
        EMAIL_INPUT.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        LOGIN_BUTTON.click();
    }
}
