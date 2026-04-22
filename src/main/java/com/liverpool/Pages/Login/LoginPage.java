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

    MobileElement goToLoginShoppingCartBtn = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/btnGoToLogin");
    MobileElement goToLoginFromMyAccount = MobileElement.forAndroid("#mx.com.liverpool.shoppingapp:id/txt_Login");
    MobileElement emailInput = MobileElement.forAndroid("android=new UiSelector().resourceId(\"username\")");
    MobileElement passInput = MobileElement.forAndroid("android=new UiSelector().resourceId(\"password\")");
    MobileElement loginBtn = MobileElement.forAndroid("//*[contains(@class, 'Button')][@text='Iniciar sesión']");
    MobileElement closeBtn = MobileElement.forAndroid("#com.android.chrome:id/close_button");

    public boolean isUserLogged() {
        LOGGER.info("Validate if user is logged");

        try {
            I.waitForDisplayed(emailInput);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean isUserLoggedFromShoppingCart() {
        LOGGER.info("Validate if user is logged from shopping cart");

        try {
            I.waitForDisplayed(goToLoginShoppingCartBtn);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void goToLoginFromMyAccount() {
        I.waitForDisplayed(goToLoginFromMyAccount);
        I.tap(goToLoginFromMyAccount);
    }

    public void login() {
        this.login(EnvVars.getEnvVar("USER_1"), EnvVars.getEnvVar("PASSWORD"));
    }

    public void login(String email, String pass) {
        LOGGER.info("Login with email: {}", email);
        I.fillField(emailInput, email);
        I.fillField(passInput, pass);

        I.tap(loginBtn);
    }

    public void closeLoginScreen() {
        LOGGER.info("Close login screen");
        I.waitForDisplayed(closeBtn);
        I.tap(closeBtn);
    }
}