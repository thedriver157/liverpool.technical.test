package com.liverpool.Pages.Login;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.EnvVars;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage {

    public LoginPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    MobileElement goToLoginBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btnGoToLogin");
    MobileElement userInput = MobileElement.forAndroid("android=new UiSelector().resourceId(\"username\")");
    MobileElement passInput = MobileElement.forAndroid("android=new UiSelector().resourceId(\"password\")");
    MobileElement loginBtn = MobileElement.forAndroid("android=new UiSelector().textContains(\"Iniciar sesión\")");
    MobileElement closeBtn = MobileElement.forAndroid("#com.android.chrome:id/close_button");

    public boolean isUserLogged() {
        LOGGER.info("Validate if user is logged");

        try {
            I.waitForDisplayed(userInput);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isUserLoggedFromShoppingCart() {
        LOGGER.info("Validate if user is logged from shopping cart");

        try {
            I.waitForDisplayed(goToLoginBtn);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void login() {
        LOGGER.info("Login");
        if (this.isUserLogged()) {
            I.fillField(userInput, EnvVars.getEnvVar("User_1"));
            I.fillField(passInput, EnvVars.getEnvVar("Password"));

            I.tap(loginBtn);
        }
    }

    public void closeLoginScreen() {
        LOGGER.info("Close login screen");
        I.waitForDisplayed(closeBtn);
        I.tap(closeBtn);
    }
}