package com.liverpool.Utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.Map;

public class Locators {

    public static Map<String, Object> androidLocator(String locator) {
        By locatorResolved = null;

        if (locator.startsWith("#")) {
            locatorResolved = AppiumBy.id(locator.substring(1));
        } else if (locator.startsWith("android=")) {
            locatorResolved = AppiumBy.androidUIAutomator(locator.substring(8));
        } else if (locator.startsWith("~")) {
            locatorResolved = AppiumBy.accessibilityId(locator.substring(1));
        } else {
            locatorResolved = AppiumBy.xpath(locator);
        }

        return Map.of("LOCATOR_RESOLVED", locatorResolved);
    }

    public static Map<String, Object> iosLocator(String locator) {
        By locatorResolved = null;

        if (locator.startsWith("#")) {
            locatorResolved = AppiumBy.id(locator.substring(1));
        } else if (locator.startsWith("~")) {
            locatorResolved = AppiumBy.accessibilityId(locator.substring(1));
        } else if (locator.startsWith("iosclasschain=")) {
            locatorResolved = AppiumBy.iOSClassChain(locator.substring(14));
        } else if (locator.startsWith("iospredicate=")) {
            locatorResolved = AppiumBy.iOSNsPredicateString(locator.substring(13));
        } else {
            locatorResolved = AppiumBy.xpath(locator);
        }

        return Map.of("LOCATOR_RESOLVED", locatorResolved);
    }
}