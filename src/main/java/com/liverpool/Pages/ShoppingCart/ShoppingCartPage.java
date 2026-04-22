package com.liverpool.Pages.ShoppingCart;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ShoppingCartPage {

    public ShoppingCartPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement goToShoppingCart = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btn_header_bag");
    MobileElement goToPay = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btnPayBottom");
    MobileElement removeProductBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btn_quantity_delete");
    MobileElement confimRemoveProductBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/button_delete_product");

    public void goToShoppingCart() {
        LOGGER.info("Go to shopping cart");
        I.waitForDisplayed(goToShoppingCart);
        I.tap(goToShoppingCart);
    }

    public void goToPay() {
        LOGGER.info("Go to pay shopping cart");
        I.waitForVisibleRefreshed(goToPay);
        I.tap(goToPay);
    }

    public void removeProduct() {
        LOGGER.info("Remove product from shopping cart");
        I.waitForDisplayed(removeProductBtn);
        I.tap(removeProductBtn);

        I.waitForDisplayed(confimRemoveProductBtn);
        I.tap(confimRemoveProductBtn);
    }
}