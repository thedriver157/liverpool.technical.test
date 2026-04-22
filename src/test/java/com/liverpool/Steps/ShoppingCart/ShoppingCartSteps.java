package com.liverpool.Steps.ShoppingCart;

import com.liverpool.Actor.I;
import com.liverpool.Pages.ShoppingCart.ShoppingCartPage;
import io.cucumber.java.en.And;

public class ShoppingCartSteps {

    @And("^access to shopping cart$")
    public void access_to_shopping_cart() {
        ShoppingCartPage shoppingCartPage = I.get().initPage(ShoppingCartPage.class);
        shoppingCartPage.goToShoppingCart();
    }

    @And("^go to pay shopping cart$")
    public void go_to_pay_shopping_cart() {
        ShoppingCartPage shoppingCartPage = I.get().initPage(ShoppingCartPage.class);
        shoppingCartPage.goToPay();
    }

    @And("^remove product from shopping cart$")
    public void remove_product_from_shopping_cart() {
        ShoppingCartPage shoppingCartPage = I.get().initPage(ShoppingCartPage.class);
        shoppingCartPage.removeProduct();
    }
}