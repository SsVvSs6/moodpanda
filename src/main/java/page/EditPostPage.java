package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditPostPage {

    private static final String BUTTON_XPATH = "//table//button[contains(text(), '%s')]";
    private static final String SUCCESS_MESSAGE_XPATH = "//*[contains(text(), '%s')]";
    private static final List<SelenideElement> RATING_SELECT = $$(By.xpath("//td//select"));
    private static final List<SelenideElement> POST_INPUT = $$(By.xpath("//td[@class='wrap']/textarea"));
    private static final List<SelenideElement> UPDATE_BUTTON = $$(By.xpath(String.format(BUTTON_XPATH, "Update")));
    private static final List<SelenideElement> DELETE_BUTTON = $$(By.xpath(String.format(BUTTON_XPATH, "Delete")));
    private static final List<SelenideElement> ADD_BUTTON = $$(By.xpath(String.format(BUTTON_XPATH, "Add")));
    private static final SelenideElement SUCCESS_EDIT_MESSAGE
            = $(By.xpath(String.format(SUCCESS_MESSAGE_XPATH, "Post updated")));
    private static final SelenideElement SUCCESS_ADD_MESSAGE
            = $(By.xpath(String.format(SUCCESS_MESSAGE_XPATH, "Posted")));
    private static final SelenideElement SUCCESS_DELETE_MESSAGE
            = $(By.xpath(String.format(SUCCESS_MESSAGE_XPATH, "Post deleted")));
    private static final int POSITION = 0;

    public EditPostPage setUpRating(String rating) {
        RATING_SELECT.get(POSITION).selectOptionByValue(rating);
        return this;
    }

    public EditPostPage fillInPostInput(String text) {
        POST_INPUT.get(POSITION).sendKeys(text);
        return this;
    }

    public EditPostPage clickAddButton() {
        ADD_BUTTON.get(POSITION).click();
        return this;
    }

    public EditPostPage clickUpdateButton() {
        UPDATE_BUTTON.get(POSITION).click();
        return this;
    }

    public EditPostPage clickDeleteButton() {
        DELETE_BUTTON.get(POSITION).click();
        return this;
    }

    public boolean isSuccessEditMessageDisplayed() {
        return SUCCESS_EDIT_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isSuccessAddMessageDisplayed() {
        return SUCCESS_ADD_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public boolean isSuccessDeleteMessageDisplayed() {
        return SUCCESS_DELETE_MESSAGE.shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
