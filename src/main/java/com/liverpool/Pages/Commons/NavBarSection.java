package com.liverpool.Pages.Commons;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class NavBarSection {

    public NavBarSection(IActions I) {
        this.I = I;
    }

    private final IActions I;

    MobileElement startSection = MobileElement.forAndroid("~Inicio");
    MobileElement exploreSection = MobileElement.forAndroid("~Explorar");
    MobileElement creditAndSavingSection = MobileElement.forAndroid("~Crédito y Ahorro");
    MobileElement servicesSection = MobileElement.forAndroid("~Servicios");
    MobileElement myAccountSection = MobileElement.forAndroid("~Mi cuenta");

    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    public void accessToNavBarSection(String section) {
        LOGGER.info("Access To NavBarSection: {}", section.toUpperCase());

        switch (section.toUpperCase()) {
            case "START" -> I.tap(startSection);
            case "EXPLORE" -> I.tap(exploreSection);
            case "CREDIT_SAVING" -> I.tap(creditAndSavingSection);
            case "SERVICES" -> I.tap(servicesSection);
            case "MY_ACCOUNT" -> I.tap(myAccountSection);
        };
    }
}