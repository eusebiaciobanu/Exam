package org.eusebia.features.admin;

import org.eusebia.features.BaseTest;
import org.eusebia.utils.Constants;
import org.junit.Test;

public class AdminLoginTest extends BaseTest {
    @Test
    public void validLoginWithUsernameTest() {
        adminLoginSteps.doLogin();
        adminLoginSteps.userIsLoggedIn(Constants.ADMIN_USER);
    }
}
