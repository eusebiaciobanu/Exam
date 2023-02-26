package org.eusebia.features.admin;

import org.eusebia.features.BaseTest;
import org.junit.Test;

public class CouponTest extends BaseTest {
    @Test
    public void canOpenCouponsPage() {
        adminLoginSteps.doLogin();
        couponsSteps.navigateToCouponsPage();
        couponsSteps.couponPageIsOpened();
    }

    @Test
    public void canCreateCoupon() {
        adminLoginSteps.doLogin();

        String couponName = String.valueOf(Math.random());

        couponsSteps.createCoupon("coupon" + couponName, 15);

        couponsSteps.couponWasCreated();
    }
}
