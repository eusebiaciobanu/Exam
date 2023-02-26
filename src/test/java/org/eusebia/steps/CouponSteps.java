package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class CouponSteps extends BaseSteps {
    @Step
    public void navigateToCouponsPage() {
        adminPage.clickCouponsButton();
    }

    @Step
    public void clickOnAddCoupon() {
        couponPage.clickOnAddCouponButton();
    }

    @Step
    public void couponPageIsOpened() {
        adminPage.pageIsOpened("Coupons");
    }

    @Step
    public void addCouponPageIsOpened() {
        adminPage.pageIsOpened("Add new coupon");
    }

    @Step
    public void typeCouponCode(String value) {
        couponPage.setCouponField(value);
    }

    @Step
    public void typeCouponAmount(int value) {
        couponPage.setCouponAmountField(value);
    }

    @Step
    public void clickOnSaveCouponButton() {
        couponPage.clickOnSaveCouponButton();
    }

    @Step
    public void couponWasCreated() {
        couponPage.couponWasCreated();
    }

    @Step
    public void createCoupon(String couponCode, int couponValue) {
        navigateToCouponsPage();
        clickOnAddCoupon();
        typeCouponCode(couponCode);
        typeCouponAmount(couponValue);
        clickOnSaveCouponButton();
    }
}
