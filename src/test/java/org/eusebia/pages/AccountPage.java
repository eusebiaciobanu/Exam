package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade welcomeTextElement;

    public boolean isWelcomeText(String userName) {
        return welcomeTextElement.containsOnlyText("Hello, " + userName + "!");
    }

    public String getWelcomeText() {
        return welcomeTextElement.getText();
    }

    public void userIsLoggedIn(String username) {
        welcomeTextElement.shouldContainOnlyText("Hello " + username + " (not " + username + "? Log out)");
    }
}
