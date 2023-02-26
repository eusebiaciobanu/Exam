package org.eusebia.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.eusebia.utils.Constants;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa2.fasttrackit.org:8008")
public class HomePage extends PageObject {

    @FindBy(css = "#menu-item-64 a")
    private WebElementFacade myAccountButton;

    @FindBy(css = "#menu-item-66 a")
    private WebElementFacade shopButton;

    @FindBy(css = ".header-cart a.cart-control")
    private WebElementFacade cartButton;

    @FindBy(id = "search")
    private WebElementFacade searchField;

    @FindBy(css = ".search-button")
    private WebElementFacade searchButton;

    public void clickMyAccountButton(){
        clickOn(myAccountButton);
    }

    public void clickShopButton(){
        clickOn(shopButton);
    }

    public void clickCartButton(){
        clickOn(cartButton);
    }

    public void navigateToAdminPage(){
        getDriver().get(Constants.ADMIN_URL);
    }

    public void navigateToHomePage(){
        getDriver().get(Constants.BASE_URL);
    }
}

