package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPage extends PageObject {
    @FindBy(id = "reg_email")
    private WebElementFacade emailField;

    @FindBy(id = "reg_password")
    private WebElementFacade passwordField;

    @FindBy(name = "register")
    private WebElementFacade registerButton;

    @FindBy(id = "advice-required-entry-pass")
    private WebElementFacade requiredPasswordElement;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessageElement;

    public void setEmailField(String value) {
        typeInto(emailField, value);
    }

    public void setPasswordField(String value) {
        typeInto(passwordField, value);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void passwordIsWrong(String email) {
        errorMessageElement.shouldContainOnlyText("ERROR: The password you entered for the email address " + email + " is incorrect. Lost your password?");
    }

    public void emailIsWrong(){
        errorMessageElement.shouldContainOnlyText("ERROR: Invalid email address. Lost your password?");
    }

    public void emailIsRequired(){
        errorMessageElement.shouldContainOnlyText("Error: Please provide a valid email address.");
    }

    public void passwordIsRequired(){
        errorMessageElement.shouldContainOnlyText("Error: Please enter an account password.");
    }

    public void userIsAlreadyRegistered() {
        errorMessageElement.shouldContainOnlyText("Error: An account is already registered with your email address. Please log in.");
    }
}
