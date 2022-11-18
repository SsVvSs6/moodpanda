package services;

import model.User;
import page.EditPostPage;

public class EditPostService {

    EditPostPage editPostPage = new EditPostPage();
    LoginService loginService = new LoginService();

    public EditPostPage openPage(User user) {
        return loginService.login(user).clickEditPostButton();
    }

    public EditPostPage addPost(String postText, String rating) {
        return editPostPage.fillInPostInput(postText)
                .setUpRating(rating)
                .clickAddButton();
    }

    public EditPostPage editRating(String rating) {
        return editPostPage.setUpRating(rating)
                .clickUpdateButton();
    }

    public EditPostPage deletePost() {
        return editPostPage.clickDeleteButton();
    }
}
