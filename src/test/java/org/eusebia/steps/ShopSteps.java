package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class ShopSteps extends BaseSteps {
    @Step
    public void navigateToShopPage() {
        homePage.clickShopButton();
    }

    @Step
    public void cartHasPrice(String value) {
        shopPage.cartHasPrice(value);
    }

    @Step
    public float getPriceOfFirstProduct() {
        return shopPage.getFirstProductPrice();
    }

    @Step
    public void addToCartFirstProduct() {
        shopPage.clickAddToCartFirstProduct();
    }

    @Step
    public void hoverOnCart() {
        shopPage.hoverOnCart();
    }

    @Step
    public void removeFirstProductFromCart() {
        shopPage.clickRemoveFirstProductFromCart();
    }

    @Step
    public void hasPageEnabled(int number) {
        shopPage.hasPageEnabled(number);
    }

    @Step
    public void changePageByNumber(int number) {
        shopPage.changePageByNumber(number);
    }

    @Step
    public void changeToNextPage() {
        shopPage.changeToNextPage();
    }

    @Step
    public void changeToPrevPage() {
        shopPage.changeToPrevPage();
    }

    @Step
    public void prevPageArrowNotVisible() {
        shopPage.prevPageArrowNotVisible();
    }

    @Step
    public void nextPageArrowNotVisible() {
        shopPage.nextPageArrowNotVisible();
    }

    @Step
    public int getNumberOfPages() {
        return shopPage.getNumberOfPages();
    }
}
