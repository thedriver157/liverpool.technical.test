package com.liverpool.Pages.Explore;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ExplorePage {

    public ExplorePage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    // Locators Explore Section
    MobileElement womanSection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Mujer\")");
    MobileElement manSection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Hombre\")");
    MobileElement electronicSection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Electrónica\")");
    MobileElement homeSection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Hogar\")");

    public void exploreSection(String section) {
        LOGGER.info("Access to explore section: {}", section.toUpperCase());

        I.waitForDisplayed(womanSection);

        switch (section.toUpperCase()) {
            case "WOMAN" -> I.tap(womanSection);
            case "MAN" -> I.tap(manSection);
            case "ELECTRONIC" -> I.tap(electronicSection);
            case "HOME" -> I.tap(homeSection);
        };
    }
}