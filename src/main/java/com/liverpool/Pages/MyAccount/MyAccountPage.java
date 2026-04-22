package com.liverpool.Pages.MyAccount;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class MyAccountPage {

    public MyAccountPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement userNameTitle = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/txt_user_name");

    public String getUserName() {
        LOGGER.info("Get UserName");
        I.waitForDisplayed(userNameTitle);
        return I.grabText(userNameTitle);
    }
}