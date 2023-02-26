package org.eusebia.features.shop;

import org.eusebia.features.BaseTest;
import org.junit.Test;

public class PaginationTest extends BaseTest {

    @Test
    public void checkDefaultPageNumber() {
        shopSteps.navigateToShopPage();

        shopSteps.hasPageEnabled(1);
    }

    @Test
    public void checkChangePageUsingPageNumber() {
        shopSteps.navigateToShopPage();

        shopSteps.changePageByNumber(2);

        shopSteps.hasPageEnabled(2);
    }

    @Test
    public void checkChangeToNextPage() {
        shopSteps.navigateToShopPage();

        shopSteps.changeToNextPage();

        shopSteps.hasPageEnabled(2);
    }

    @Test
    public void checkChangeToPrevPage() {
        shopSteps.navigateToShopPage();

        shopSteps.changePageByNumber(3);

        shopSteps.changeToPrevPage();

        shopSteps.hasPageEnabled(2);
    }

    @Test
    public void checkPrevPageArrowNotVisibleOnFirstPage() {
        shopSteps.navigateToShopPage();

        shopSteps.prevPageArrowNotVisible();
    }

    @Test
    public void checkNextPageArrowNotVisibleOnLastPage() {
        shopSteps.navigateToShopPage();

        int numberOfPages = shopSteps.getNumberOfPages();

        shopSteps.changePageByNumber(numberOfPages);

        shopSteps.nextPageArrowNotVisible();
    }
}
