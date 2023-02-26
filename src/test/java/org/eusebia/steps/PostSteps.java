package org.eusebia.steps;

import net.thucydides.core.annotations.Step;

public class PostSteps extends BaseSteps {
    @Step
    public void navigateToPostsPage() {
        adminPage.clickPostsButton();
    }

    @Step
    public void clickOnAddPost() {
        postPage.clickOnAddPostButton();
    }

    @Step
    public void postsPageIsOpened() {
        adminPage.pageIsOpened("Posts");
    }

    @Step
    public void addPostPageIsOpened() {
        adminPage.pageIsOpened("Add new post");
    }

    @Step
    public void typePostCode(String value) {
        postPage.setPostField(value);
    }

    @Step
    public void clickOnSavePostButton() {
        postPage.clickOnSavePostButton();
    }

    @Step
    public void postWasCreated() {
        postPage.postWasCreated();
    }

    @Step
    public void createPost(String postCode) {
        navigateToPostsPage();
        clickOnAddPost();
        typePostCode(postCode);
        clickOnSavePostButton();
    }

    @Step
    public void viewPost() {
        postPage.clickOnViewPost();
    }

    @Step
    public void writeComment(String comment) {
        postPage.writeComment(comment);
        postPage.clickOnPostCommentButton();
    }

    @Step
    public void commentTextIsRequired() {
        postPage.commentTextIsRequired();
    }

    @Step
    public void notAllowedToComment() {
        postPage.notAllowedToComment();
    }

    @Step
    public void logout() {
        postPage.clickOnLogoutButton();
    }
}
