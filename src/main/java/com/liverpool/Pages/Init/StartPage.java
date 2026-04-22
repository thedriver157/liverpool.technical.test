package com.liverpool.Pages.Init;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class StartPage {

    public StartPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement acceptCompabilityMsgBtn = MobileElement.forAndroid("#android:id/button2");
    MobileElement allowTrackingPermissionsBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btn_allow_permission");
    MobileElement skipTutorialBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/skip_action");

    public void closeCompatibilityAlertWindow() {
        try {
            LOGGER.info("Close Compatibility Alert Window");
            I.waitForVisible(acceptCompabilityMsgBtn, 2);
            I.tap(acceptCompabilityMsgBtn);
        } catch (Exception e) {
            LOGGER.error("Element not visible: {}", acceptCompabilityMsgBtn);
        }
    }

    public void allowTrackingPermissions() {
        LOGGER.info("Allow Tracking Permissions");
        I.waitForVisible(allowTrackingPermissionsBtn, 2);
        I.tap(allowTrackingPermissionsBtn);
    }

    public void skipTutorial() {
        LOGGER.info("Skip Tutorial");
        I.waitForDisplayed(skipTutorialBtn, 60);
        I.tap(skipTutorialBtn);
    }
}