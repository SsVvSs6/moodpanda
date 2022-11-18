package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.EditPostService;

public class EditPostTest extends BaseTest {

    User user;
    EditPostService editPostService;
    private static final String ADD_POST_RATING = "5";
    private static final String EDIT_POST_RATING = "10";
    private static final String POST_VALID_TEXT = "No reason";
    private static final String POST_INVALID_TEXT = "No";

    @BeforeClass
    public void openEditPostPage() {
        user = new User();
        editPostService = new EditPostService();
        editPostService.openPage(user);
    }

    @Test(priority = 1, description = "Successful adding post")
    public void checkAddPostTest() {
        Assert.assertTrue(editPostService.addPost(POST_VALID_TEXT, ADD_POST_RATING)
                .isSuccessAddMessageDisplayed(),
                "Post is not added");
    }

    @Test(priority = 2, description = "Successful editing post rating")
    public void checkEditPostTest() {
        Assert.assertTrue(editPostService.editRating(EDIT_POST_RATING)
                .isSuccessEditMessageDisplayed(),
                "Post is not changed");
    }

    @Test(priority = 3, description = "Successful deleting post")
    public void checkDeletePostTest() {
        Assert.assertTrue(editPostService.deletePost()
                .isSuccessDeleteMessageDisplayed(),
                "Post is not deleted");
    }

    @Test(priority = 4, description = "Error if post text is short")
    public void checkPostTextIsInvalidTest() {
        Assert.assertTrue(editPostService.addPost(POST_INVALID_TEXT, ADD_POST_RATING).
                isUnsuccessfulAddMessageDisplayed(),
                "Post is created");
    }
}
