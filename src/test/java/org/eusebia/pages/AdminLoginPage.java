package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AdminLoginPage extends PageObject {
    @FindBy(id = "user_login")
    private WebElementFacade usernameField;

    @FindBy(id = "user_pass")
    private WebElementFacade passwordField;

    @FindBy(name = "wp-submit")
    private WebElementFacade loginButton;

    public void setUsernameField(String value) {
        typeInto(usernameField, value);
    }

    public void setPasswordField(String value) {
        typeInto(passwordField, value);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }
}
