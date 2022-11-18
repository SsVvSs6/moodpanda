package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.EditPostPage;
import services.LoginService;

public class EditPostTest extends BaseTest {

    User user;
    EditPostPage editPostPage;
    private static final String ADD_POST_RATING = "5";
    private static final String EDIT_POST_RATING = "10";
    private static final String POST_TEXT = "No reason";

    @BeforeClass
    public void openEditPostPage() {
        user = new User();
        editPostPage = new LoginService()
                .login(user)
                .clickEditPostButton();
    }

    @Test(priority = 1)
    public void checkAddPostTest() {
        editPostPage.fillInPostInput(POST_TEXT)
                .setUpRating(ADD_POST_RATING)
                .clickAddButton();
        Assert.assertTrue(editPostPage.isSuccessAddMessageDisplayed(), "Post is not added");
    }

    @Test(priority = 2)
    public void checkEditPostTest() {
        editPostPage.setUpRating(EDIT_POST_RATING)
                .clickUpdateButton();
        Assert.assertTrue(editPostPage.isSuccessEditMessageDisplayed(), "Post is not changed");
    }

    @Test(priority = 3)
    public void checkDeletePostTest() {
        editPostPage.clickDeleteButton();
        Assert.assertTrue(editPostPage.isSuccessDeleteMessageDisplayed(), "Post is not deleted");
    }
}
