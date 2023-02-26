package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CouponPage extends PageObject {
    @FindBy(css = "a.page-title-action")
    private WebElementFacade addCouponButton;

    @FindBy(id = "title")
    private WebElementFacade couponField;

    @FindBy(id = "coupon_amount")
    private WebElementFacade couponAmountField;

    @FindBy(css = "div#message.updated.notice p")
    private WebElementFacade messageElement;

    @FindBy(id = "publish")
    private WebElementFacade saveCouponButton;

    public void clickOnAddCouponButton() {
        clickOn(addCouponButton);
    }

    public void setCouponField(String value) {
        typeInto(couponField, value);
    }

    public void setCouponAmountField(int value) {
        typeInto(couponAmountField, Integer.toString(value));
    }

    public void clickOnSaveCouponButton() {
        clickOn(saveCouponButton);
    }

    public void couponWasCreated(){
        messageElement.shouldContainOnlyText("Coupon updated.");
    }
}
