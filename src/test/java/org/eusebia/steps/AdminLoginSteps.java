package org.eusebia.steps;

import net.thucydides.core.annotations.Step;
import org.eusebia.utils.Constants;

public class AdminLoginSteps extends BaseSteps {
    @Step
    public void navigateToAdminPage() {
        homePage.navigateToAdminPage();
    }

    @Step
    public void typeUsername(String value) {
        adminLoginPage.setUsernameField(value);
    }

    @Step
    public void typePassword(String password) {
        adminLoginPage.setPasswordField(password);
    }

    @Step
    public void clickLogin() {
        adminLoginPage.clickLoginButton();
    }

    @Step
    public void userIsLoggedIn(String username) {
        adminPage.userIsLoggedIn(username);
    }

    @Step
    public void doLogin() {
        navigateToAdminPage();
        typeUsername(Constants.ADMIN_USER);
        typePassword(Constants.ADMIN_PASSWORD);
        clickLogin();
    }
}
