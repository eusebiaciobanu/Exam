package org.eusebia.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PostPage extends PageObject {
    @FindBy(css = "a.page-title-action")
    private WebElementFacade addPostButton;

    @FindBy(id = "title")
    private WebElementFacade postField;

    @FindBy(id = "post_amount")
    private WebElementFacade postBodyField;

    @FindBy(css = "div#message.updated.notice p")
    private WebElementFacade messageElement;

    @FindBy(css = "#error-page p:nth-child(2)")
    private WebElementFacade commentErrorMessageElement;

    @FindBy(id = "publish")
    private WebElementFacade savePostButton;

    @FindBy(id = "submit")
    private WebElementFacade postCommentButton;

    @FindBy(id = "comment")
    private WebElementFacade commentField;

    @FindBy(css = "div#message.updated.notice p a")
    private WebElementFacade viewPostButton;

    @FindBy(css = "p.logged-in-as a:nth-child(2)")
    private WebElementFacade logoutButton;

    @FindBy(css = "p.must-log-in")
    private WebElementFacade mustLogInMessage;

    public void clickOnAddPostButton() {
        clickOn(addPostButton);
    }

    public void setPostField(String value) {
        typeInto(postField, value);
    }

    public void clickOnSavePostButton() {
        clickOn(savePostButton);
    }

    public void clickOnViewPost() {
        clickOn(viewPostButton);
    }

    public void postWasCreated() {
        messageElement.shouldContainOnlyText("Post published. View post");
    }

    public void writeComment(String value) {
        typeInto(commentField, value);
    }

    public void clickOnPostCommentButton() {
        clickOn(postCommentButton);
    }

    public void clickOnLogoutButton() {
        clickOn(logoutButton);
    }

    public void commentTextIsRequired() {
        commentErrorMessageElement.shouldContainOnlyText("ERROR: please type a comment.");
    }

    public void notAllowedToComment() {
        mustLogInMessage.shouldContainOnlyText("You must be logged in to post a comment.");
    }
}
