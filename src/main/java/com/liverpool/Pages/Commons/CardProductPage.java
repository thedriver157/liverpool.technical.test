package com.liverpool.Pages.Commons;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CardProductPage {

    public CardProductPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement titleProduct = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/headinfo_section_view_root");
    MobileElement addToCartBtn = MobileElement.forAndroid("android=new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"mx.com.liverpool.shoppingapp:id/btnAddMyBag\"))");
    MobileElement skipInsuranceBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btnNotThanks");

    public void addProductToCart() {
        LOGGER.info("Add product to Cart");
        I.waitForDisplayed(titleProduct);
        I.tap(addToCartBtn);
    }

    public void skipInsurance() {
        LOGGER.info("Skip insurance");
        I.waitForDisplayed(skipInsuranceBtn);
        I.tap(skipInsuranceBtn);
    }
}