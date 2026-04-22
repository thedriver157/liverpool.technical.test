package com.liverpool.Pages.Home;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage {

    public HomePage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement homeInputSearch = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/edt_header_searchbar_old");
    MobileElement inputSearch = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/edt_header_searchbar");

    public void searchProduct(String product) {
        LOGGER.info("Search product: {}", product);
        I.waitForVisible(homeInputSearch);
        I.tap(homeInputSearch);

        //I.waitForVisibleRefreshed(inputSearch);
        I.waitForDisplayed(inputSearch);
        I.fillField(inputSearch, product);
        I.pressKey(AndroidKey.ENTER);
    }
}