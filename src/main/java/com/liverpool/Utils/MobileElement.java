package com.liverpool.Utils;

import com.liverpool.Enums.EMobilePlatforms;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class MobileElement {
    private String androidLocatorStr;
    private String iosLocatorStr;

    private MobileElement(Map<String, String> locatorMap) {
        if (locatorMap.containsKey(EMobilePlatforms.ANDROID.getMobilePlatform())) {
            this.androidLocatorStr = (String) locatorMap.get(EMobilePlatforms.ANDROID.getMobilePlatform());
        }

        if (locatorMap.containsKey(EMobilePlatforms.IOS.getMobilePlatform())) {
            this.iosLocatorStr = (String) locatorMap.get(EMobilePlatforms.IOS.getMobilePlatform());
        }
    }

    private MobileElement(Map<String, String> androidLocatorMap, Map<String, String> iosLocatorMap) {
        if (androidLocatorMap != null) {
            this.androidLocatorStr = (String) androidLocatorMap.get(EMobilePlatforms.ANDROID.getMobilePlatform());
        }

        if (iosLocatorMap != null) {
            this.iosLocatorStr = (String) iosLocatorMap.get(EMobilePlatforms.IOS.getMobilePlatform());
        }
    }

    public static MobileElement forAndroid(String locator) {
        return new MobileElement(Map.of(EMobilePlatforms.ANDROID.getMobilePlatform(), locator));
    }

    public static MobileElement forIos(String locator) {
        return new MobileElement(Map.of(EMobilePlatforms.IOS.getMobilePlatform(), locator));
    }

    public static MobileElement forMobile(String androidLocator, String iosLocator) {
        return new MobileElement(
                Map.of(EMobilePlatforms.ANDROID.getMobilePlatform(), androidLocator),
                Map.of(EMobilePlatforms.IOS.getMobilePlatform(), iosLocator)
        );
    }

    public <T> WebElement locatorResolve(T driverStrategy) {
        if (driverStrategy instanceof AndroidDriver androidDriver) {
            return androidDriver.findElement((By) Locators.androidLocator(this.androidLocatorStr).get("LOCATOR_RESOLVED"));
        } else if (driverStrategy instanceof IOSDriver iosDriver){
            return iosDriver.findElement((By) Locators.iosLocator(this.iosLocatorStr).get("LOCATOR_RESOLVED"));
        } else {
            throw new RuntimeException("Error element not support");
        }
    }

    public <T> List<WebElement> locatorsResolve(T driverStrategy) {
        if (driverStrategy instanceof AndroidDriver androidDriver) {
            return androidDriver.findElements((By) Locators.androidLocator(this.androidLocatorStr).get("LOCATOR_RESOLVED"));
        } else if (driverStrategy instanceof IOSDriver iosDriver){
            return iosDriver.findElements((By) Locators.iosLocator(this.iosLocatorStr).get("LOCATOR_RESOLVED"));
        } else {
            throw new RuntimeException("Error element not support");
        }
    }
}