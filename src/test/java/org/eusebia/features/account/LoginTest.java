package org.eusebia.features.account;

import org.eusebia.features.BaseTest;
import org.eusebia.utils.Constants;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginWithEmailTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.typeUsername(Constants.USER_EMAIL);
        loginSteps.typePassword(Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void validLoginWithUsernameTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.typeUsername(Constants.USER_NAME);
        loginSteps.typePassword(Constants.USER_PASS);
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void invalidPasswordLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.typeUsername(Constants.USER_EMAIL);
        loginSteps.typePassword("123123123123");
        loginSteps.clickLogin();
        loginSteps.passwordIsWrong(Constants.USER_EMAIL);
    }

    @Test
    public void invalidEmailAddressTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.typeUsername("testrandom@lalala.com");
        loginSteps.typePassword("12345");
        loginSteps.clickLogin();
        loginSteps.emailIsWrong();
    }

    @Test
    public void verifyUsernameRequiredFieldTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.clickLogin();
        loginSteps.usernameIsRequired();
    }

    @Test
    public void verifyPasswordRequiredFieldTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.typeUsername(Constants.USER_EMAIL);
        loginSteps.clickLogin();
        loginSteps.passwordIsRequired();
    }
}
