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
        } else if (locator.startsWith("-ios class chain")) {
            locatorResolved = AppiumBy.iOSClassChain(locator);
        } else if (locator.startsWith("-ios predicate")) {
            locatorResolved = AppiumBy.iOSNsPredicateString(locator);
        } else {
            locatorResolved = AppiumBy.xpath(locator);
        }

        return Map.of("LOCATOR_RESOLVED", locatorResolved);
    }
}