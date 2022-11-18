package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GlobalPage {

    private static final SelenideElement EDIT_POST_LINK
            = $(By.xpath("//aside[contains(@class,'column')]//a[contains(@href, 'mydata')]"));

    public EditPostPage clickEditPostButton() {
        EDIT_POST_LINK.click();
        return new EditPostPage();
    }
}
