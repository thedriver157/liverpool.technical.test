package com.liverpool.Pages.Explore;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ExploreSecondSubsectionPage {

    public ExploreSecondSubsectionPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    // Locators Electronic Subsection
    MobileElement pcGamerSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"PC Gamer\")");
    MobileElement laptopGamerSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Laptop Gamer\")");

    public void exploreGamingSubsection(String subsection) {
        LOGGER.info("Access to explore Gaming subsection: {}", subsection.toUpperCase());

        I.waitForDisplayed(pcGamerSubsection);

        switch (subsection.toUpperCase()) {
            case "PC_GAMER" -> I.tap(pcGamerSubsection);
            case "LAPTOP_GAMER" -> I.tap(laptopGamerSubsection);
        };
    }
}