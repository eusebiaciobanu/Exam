package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa2.fasttrackit.org:8008/wp-admin/index.php")
public class AdminPage extends PageObject {
    @FindBy(css = "#toplevel_page_woocommerce a")
    private WebElementFacade wooCommerceButton;

    @FindBy(css = "#toplevel_page_woocommerce ul.wp-submenu li:nth-child(3) a")
    private WebElementFacade couponsButton;

    @FindBy(css = "#menu-posts a")
    private WebElementFacade postsButton;

    @FindBy(css = "#wp-admin-bar-my-account a.ab-item .display-name")
    private WebElementFacade userNameElement;

    @FindBy(css = "h1.wp-heading-inline")
    private WebElementFacade pageTitle;

    public void userIsLoggedIn(String username) {
        userNameElement.shouldContainOnlyText(username);
    }

    public void pageIsOpened(String title) {
        pageTitle.shouldContainOnlyText(title);
    }

    public void clickCouponsButton() {
        clickOn(wooCommerceButton);

        clickOn(couponsButton);
    }

    public void clickPostsButton() {
        clickOn(postsButton);
    }
}
