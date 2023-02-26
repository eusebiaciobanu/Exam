package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class CartPage extends PageObject {
    @FindBy(id = "coupon_code")
    private WebElementFacade couponField;

    @FindBy(css = ".product-quantity .quantity input")
    private WebElementFacade firstProductQuantity;

    @FindBy(css = ".woocommerce p.cart-empty")
    private WebElementFacade emptyCartMessage;

    @FindBy(css = ".return-to-shop a")
    private WebElementFacade returnToShopButton;

    @FindBy(name = "apply_coupon")
    private WebElementFacade applyCouponButton;

    @FindBy(name = "update_cart")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessageElement;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade messageElement;

    @FindBy(css = "tr.cart-subtotal span.woocommerce-Price-amount")
    private WebElementFacade subtotalValue;

    @FindBy(css = "tr.order-total span.woocommerce-Price-amount")
    private WebElementFacade totalValue;

    @FindBy(css = "td.product-remove a.remove")
    private List<WebElementFacade> removeItemButtons;

    public void cartIsEmpty() {
        emptyCartMessage.shouldContainOnlyText("Your cart is currently empty.");
    }

    public void returnToShop() {
        clickOn(returnToShopButton);
    }

    public void applyCoupon(String coupon) {
        typeInto(couponField, coupon);

        clickOn(applyCouponButton);
    }

    public void setFirstProductQuantity(int value) {
        typeInto(firstProductQuantity, Integer.toString(value));

        clickOn(updateCartButton);
    }

    public void couponValueIsRequired() {
        errorMessageElement.shouldContainOnlyText("Please enter a coupon code.");
    }

    public void checkCouponIsInvalid(String coupon) {
        errorMessageElement.shouldContainOnlyText("Coupon \"" + coupon + "\" does not exist!");
    }

    public void checkCouponWasApplied() {
        messageElement.shouldContainOnlyText("Coupon code applied successfully.");
    }

    public void checkTotalPrice(float price) {
        totalValue.shouldContainOnlyText(String.format("%.2f", price).replace(".", ",") + " lei");
    }
}
