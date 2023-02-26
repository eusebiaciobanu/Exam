package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class RegisterSteps extends BaseSteps {
    @Step
    public void navigateToRegisterPage() {
        homePage.clickMyAccountButton();
    }

    @Step
    public void typeUsername(String value) {
        registerPage.setEmailField(value);
    }

    @Step
    public void typePassword(String password) {
        registerPage.setPasswordField(password);
    }

    @Step
    public void clickRegister() {
        registerPage.clickRegisterButton();
    }

    @Step
    public void userIsLoggedIn(String username) {
        accountPage.userIsLoggedIn(username);
    }

    @Step
    public void userIsAlreadyRegistered() {
        registerPage.userIsAlreadyRegistered();
    }

    @Step
    public void emailIsRequired() {
        registerPage.emailIsRequired();
    }

    @Step
    public void passwordIsRequired() {
        registerPage.passwordIsRequired();
    }
}
