package org.eusebia.features.account;

import org.eusebia.features.BaseTest;
import org.eusebia.utils.Constants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void validRegisterTest() {
        registerSteps.navigateToRegisterPage();

        String username = String.valueOf(Math.random());

        registerSteps.typeUsername(username  + "@gmail.com");
        registerSteps.typePassword(Constants.USER_PASS);
        registerSteps.clickRegister();
        registerSteps.userIsLoggedIn(username);
    }

    @Test
    public void userIsAlreadyRegistered() {
        registerSteps.navigateToRegisterPage();
        registerSteps.typeUsername(Constants.USER_EMAIL);
        registerSteps.clickRegister();
        registerSteps.userIsAlreadyRegistered();
    }

    @Test
    public void verifyEmailRequiredFieldTest() {
        registerSteps.navigateToRegisterPage();
        registerSteps.clickRegister();
        registerSteps.emailIsRequired();
    }

    @Test
    public void verifyPasswordRequiredFieldTest() {
        registerSteps.navigateToRegisterPage();
        String username = String.valueOf(Math.random());

        registerSteps.typeUsername(username  + "@gmail.com");
        registerSteps.clickRegister();
        registerSteps.passwordIsRequired();
    }
}
