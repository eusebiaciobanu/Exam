package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class CartSteps extends BaseSteps {
    @Step
    public void navigateToCartPage() {
        homePage.clickCartButton();
    }

    @Step
    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @Step
    public void returnToShop() {
        cartPage.returnToShop();
    }

    @Step
    public void cartIsEmpty() {
        cartPage.cartIsEmpty();
    }

    @Step
    public void applyCoupon(String coupon) {
        cartPage.applyCoupon(coupon);
    }

    @Step
    public void setFirstProductQuantity(int value) {
        cartPage.setFirstProductQuantity(value);
    }

    @Step
    public void checkCouponIsInvalid(String coupon) {
        cartPage.checkCouponIsInvalid(coupon);
    }

    @Step
    public void checkCouponWasApplied() {
        cartPage.checkCouponWasApplied();
    }

    @Step
    public void couponValueIsRequired() {
        cartPage.couponValueIsRequired();
    }

    @Step
    public void checkTotalPrice(float value) {
        cartPage.checkTotalPrice(value);
    }
}
