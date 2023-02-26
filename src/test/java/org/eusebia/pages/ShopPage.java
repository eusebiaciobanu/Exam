package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ShopPage extends PageObject {
    @FindBy(css = ".header-cart span.woocommerce-Price-amount")
    private WebElementFacade cartPrice;

    @FindBy(css = ".wr-shop .products .item:first-child .woocommerce-Price-amount")
    private WebElementFacade firstProductPrice;

    @FindBy(css = ".wr-shop .products .item:first-child .action .add-cart")
    private WebElementFacade addToCartFirstProductButton;

    @FindBy(css = ".header-cart")
    private WebElementFacade headerCart;

    @FindBy(css = ".header-cart .cart-content .widget_shopping_cart_content ul.woocommerce-mini-cart li:first-child a.remove_from_cart_button")
    private WebElementFacade removeFirstProductFromCart;

    @FindBy(css = ".woocommerce-pagination .page-numbers span.page-numbers.current")
    private WebElementFacade enabledPage;

    @FindBy(css = "ul.page-numbers li a.page-numbers.prev")
    private WebElementFacade prevPageArrow;

    @FindBy(css = "ul.page-numbers li a.page-numbers.next")
    private WebElementFacade nextPageArrow;

    public void cartHasPrice(String value) {
        cartPrice.shouldContainOnlyText(value);
    }

    public float getFirstProductPrice() {
        String value = firstProductPrice.getText();

        return Float.parseFloat(value.replace(",", ".").replace(" lei", ""));
    }

    public void clickAddToCartFirstProduct() {
        clickOn(addToCartFirstProductButton);
    }

    public void clickRemoveFirstProductFromCart() {
        removeFirstProductFromCart.waitUntilVisible();
        clickOn(removeFirstProductFromCart);
    }

    public void hoverOnCart() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(headerCart).perform();
    }

    public void hasPageEnabled(int number) {
        enabledPage.shouldContainOnlyText(Integer.toString(number));

        if (number > 1) {
            String currentUrl = getDriver().getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("paged=" + number));
        }
    }

    public void changePageByNumber(int number) {
        List<WebElementFacade> pageLinks = findAll("ul.page-numbers li a:not(.prev):not(.next)");

        for (WebElementFacade link : pageLinks) {
            if (link.getText().equals(Integer.toString(number))) {
                clickOn(link);
                break;
            }
        }
    }

    public void changeToNextPage() {
        clickOn(nextPageArrow);
    }

    public void changeToPrevPage() {
        clickOn(prevPageArrow);
    }

    public void prevPageArrowNotVisible() {
        prevPageArrow.shouldNotBeVisible();
    }

    public void nextPageArrowNotVisible() {
        nextPageArrow.shouldNotBeVisible();
    }

    public int getNumberOfPages() {
        List<WebElementFacade> pageLinks = findAll("ul.page-numbers li a:not(.prev):not(.next)");

        return pageLinks.size() + 1;
    }
}
