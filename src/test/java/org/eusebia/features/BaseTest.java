package org.eusebia.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.eusebia.steps.*;
import org.eusebia.utils.Constants;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
abstract public class BaseTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    protected LoginSteps loginSteps;

    @Steps
    protected AdminLoginSteps adminLoginSteps;

    @Steps
    protected RegisterSteps registerSteps;

    @Steps
    protected ShopSteps shopSteps;

    @Steps
    protected CartSteps cartSteps;

    @Steps
    protected CouponSteps couponsSteps;

    @Steps
    protected PostSteps postsSteps;

    @Before
    public void initTests() {
        driver.manage().window().maximize();
        driver.get(Constants.BASE_URL);
    }
}
