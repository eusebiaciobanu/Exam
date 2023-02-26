package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(name = "login")
    private WebElementFacade loginButton;

    @FindBy(id = "advice-required-entry-pass")
    private WebElementFacade requiredPasswordElement;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessageElement;

    public void setUsernameField(String value) {
        typeInto(usernameField, value);
    }

    public void setPasswordField(String value) {
        typeInto(passwordField, value);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public String getRequiredPasswordText() {
        waitFor(requiredPasswordElement);

        return requiredPasswordElement.getText();
    }

    public void passwordIsWrong(String email) {
        errorMessageElement.shouldContainOnlyText("ERROR: The password you entered for the email address " + email + " is incorrect. Lost your password?");
    }

    public void emailIsWrong(){
        errorMessageElement.shouldContainOnlyText("ERROR: Invalid email address. Lost your password?");
    }

    public void usernameIsRequired(){
        errorMessageElement.shouldContainOnlyText("Error: Username is required.");
    }

    public void passwordIsRequired(){
        errorMessageElement.shouldContainOnlyText("ERROR: The password field is empty.");
    }
}
