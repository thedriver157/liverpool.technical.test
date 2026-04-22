package com.liverpool.Pages.Commons;

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
    MobileElement dontShowAgainMsgBtn = MobileElement.forAndroid("#android:id/button1");
    MobileElement allowTrackingPermissionsBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btn_allow_permission");
    MobileElement skipTutorialBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/skip_action");

    public void acceptCompatibilityAlertWindow() {
        try {
            LOGGER.info("Accept compatibility alert window");
            I.waitForVisible(acceptCompabilityMsgBtn, 2);
            I.tap(acceptCompabilityMsgBtn);
        } catch (Exception e) {
            LOGGER.error("Element not visible: {}", acceptCompabilityMsgBtn);
        }
    }

    public void dontShowAgainCompatibilityAlertWindow() {
        try {
            LOGGER.info("Don't show again compatibility alert window");
            I.waitForVisible(dontShowAgainMsgBtn, 2);
            I.tap(dontShowAgainMsgBtn);
        } catch (Exception e) {
            LOGGER.error("Element not visible: {}", dontShowAgainMsgBtn);
        }
    }

    public void allowTrackingPermissions() {
        LOGGER.info("Allow tracking permissions");
        I.waitForVisible(allowTrackingPermissionsBtn, 2);
        I.tap(allowTrackingPermissionsBtn);
    }

    public void skipTutorial() {
        LOGGER.info("Skip tutorial");
        I.waitForDisplayed(skipTutorialBtn, 60);
        I.tap(skipTutorialBtn);
    }
}