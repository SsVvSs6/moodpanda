package services;

import model.User;
import page.GlobalPage;
import page.LoginPage;

public class LoginService {

    LoginPage loginPage = new LoginPage();

    public GlobalPage login(User user) {
        loginPage.openPage()
                .enterEmail(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return new GlobalPage();
    }
}
