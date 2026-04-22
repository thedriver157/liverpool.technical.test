package com.liverpool.Steps.Common;

import com.liverpool.Actor.I;
import com.liverpool.Pages.Commons.CardProductPage;
import io.cucumber.java.en.When;

public class CardProductSteps {

    @When("^add product to shopping cart without insurance$")
    public void add_product_to_shopping_cart_without_insurance() {
        CardProductPage cardProductPage = I.get().initPage(CardProductPage.class);
        cardProductPage.addProductToCart();
        cardProductPage.skipInsurance();
    }
}