package org.eusebia.features.shop;

import org.eusebia.features.BaseTest;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkDefaultCartPrice() {
        shopSteps.navigateToShopPage();

        shopSteps.cartHasPrice("0,00 lei");
    }

    @Test
    public void checkCartPriceIsUpdatedOnProductAddToCart() {
        shopSteps.navigateToShopPage();

        float price = shopSteps.getPriceOfFirstProduct();

        shopSteps.addToCartFirstProduct();

        shopSteps.cartHasPrice(String.format("%.2f", price).replace(".", ",") + " lei");
    }

    @Test
    public void checkCartPriceIsDecreasedWhenItemIsRemoved() {
        shopSteps.navigateToShopPage();

        shopSteps.addToCartFirstProduct();

        shopSteps.hoverOnCart();

        shopSteps.removeFirstProductFromCart();

        shopSteps.cartHasPrice("0,00 lei");
    }
}
