package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends BaseSteps {
    @Step
    public void navigateToLoginPage() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void typeUsername(String value) {
        loginPage.setUsernameField(value);
    }

    @Step
    public void typePassword(String password) {
        loginPage.setPasswordField(password);
    }

    @Step
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Step
    public void userIsLoggedIn(String username) {
        accountPage.userIsLoggedIn(username);
    }

    @Step
    public void passwordIsWrong(String email) {
        loginPage.passwordIsWrong(email);
    }

    @Step
    public void emailIsWrong() {
        loginPage.emailIsWrong();
    }

    @Step
    public void usernameIsRequired() {
        loginPage.usernameIsRequired();
    }

    @Step
    public void passwordIsRequired() {
        loginPage.passwordIsRequired();
    }
}
