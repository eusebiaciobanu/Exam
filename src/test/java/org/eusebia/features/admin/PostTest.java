package org.eusebia.features.admin;

import org.eusebia.features.BaseTest;
import org.junit.Test;

public class PostTest extends BaseTest {
    @Test
    public void canOpenPostsPage() {
        adminLoginSteps.doLogin();
        postsSteps.navigateToPostsPage();
        postsSteps.postsPageIsOpened();
    }

    @Test
    public void canCreatePost() {
        adminLoginSteps.doLogin();

        String postName = String.valueOf(Math.random());

        postsSteps.createPost("Post " + postName);
        postsSteps.postWasCreated();
    }

    @Test
    public void commentTextIsRequired() {
        adminLoginSteps.doLogin();

        String postName = String.valueOf(Math.random());

        postsSteps.createPost("Post " + postName);

        postsSteps.viewPost();

        postsSteps.writeComment("");

        postsSteps.commentTextIsRequired();
    }

    @Test
    public void canCommentOnPostIfLoggedIn() {
        adminLoginSteps.doLogin();

        String postName = String.valueOf(Math.random());

        postsSteps.createPost("Post " + postName);

        postsSteps.viewPost();

        postsSteps.writeComment("test comment");
    }

    @Test
    public void canNotCommentOnPostIfNotLoggedIn() {
        adminLoginSteps.doLogin();

        String postName = String.valueOf(Math.random());

        postsSteps.createPost("Post " + postName);

        postsSteps.viewPost();

        postsSteps.logout();

        postsSteps.notAllowedToComment();
    }
}
