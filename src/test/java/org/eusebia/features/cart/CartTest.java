package org.eusebia.features.cart;

import org.eusebia.features.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class CartTest extends BaseTest {
    @Test
    public void checkCartIsEmptyByDefault() {
        cartSteps.navigateToCartPage();

        cartSteps.cartIsEmpty();
    }

    @Test
    public void checkAddProductToCart() {
        cartSteps.navigateToCartPage();

        cartSteps.cartIsEmpty();

        cartSteps.returnToShop();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();
    }

    @Test
    public void checkCartTotal() {
        shopSteps.navigateToShopPage();

        float total = shopSteps.getPriceOfFirstProduct();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();

        cartSteps.checkTotalPrice(total);
    }

    @Test
    public void checkUpdateCart() {
        shopSteps.navigateToShopPage();


        float price = shopSteps.getPriceOfFirstProduct();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();

        cartSteps.setFirstProductQuantity(3);

        cartSteps.checkTotalPrice(price * 3);
    }

    @Test
    public void checkCouponValueIsRequired() {
        shopSteps.navigateToShopPage();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();

        cartSteps.applyCoupon("");

        cartSteps.couponValueIsRequired();
    }

    @Test
    public void checkInvalidCoupon() {
        shopSteps.navigateToShopPage();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();

        cartSteps.applyCoupon("asd");

        cartSteps.checkCouponIsInvalid("asd");
    }

    @Test
    public void checkValidCoupon() {
        adminLoginSteps.doLogin();

        String couponName = "coupon" + Math.random();

        int couponValue = 15;

        couponsSteps.createCoupon(couponName, couponValue);

        cartSteps.navigateToHomePage();

        shopSteps.navigateToShopPage();

        shopSteps.addToCartFirstProduct();

        cartSteps.navigateToCartPage();

        cartSteps.applyCoupon(couponName);

        cartSteps.checkCouponWasApplied();
    }
}
