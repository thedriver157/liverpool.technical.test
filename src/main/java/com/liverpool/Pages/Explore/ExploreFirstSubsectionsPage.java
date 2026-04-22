package com.liverpool.Pages.Explore;

import com.liverpool.Actor.IActions;
import com.liverpool.Utils.MobileElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ExploreFirstSubsectionsPage {

    public ExploreFirstSubsectionsPage(IActions I) {
        this.I = I;
    }

    private final IActions I;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    // Locators Electronic Subsection
    MobileElement phonesSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Celulares y Telefonía\")");
    MobileElement tvAndVideoSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"TV y Video\")");
    MobileElement computingSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Computación\")");
    MobileElement audioSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Audio\")");
    MobileElement camerasAndPhotoSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Cámaras y Fotografía\")");
    MobileElement gamingSubsection = MobileElement.forAndroid("android=new UiSelector().textContains(\"Gaming\")");

    public void exploreElectronicSubsection(String subsection) {
        LOGGER.info("Access to explore Electronic subsection: {}", subsection.toUpperCase());

        I.waitForDisplayed(phonesSubsection);

        switch (subsection.toUpperCase()) {
            case "PHONES" -> I.tap(phonesSubsection);
            case "TV_AND_VIDEO" -> I.tap(tvAndVideoSubsection);
            case "COMPUTING" -> I.tap(computingSubsection);
            case "AUDIO" -> I.tap(audioSubsection);
            case "CAMERAS" -> I.tap(camerasAndPhotoSubsection);
            case "GAMING" -> I.tap(gamingSubsection);
        };
    }
}