package com.liverpool.Driver;

import com.liverpool.Interfaces.IDriverStrategy;
import com.liverpool.Models.MobileConfigModel;
import com.liverpool.Utils.Json;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.time.Duration;
import java.util.Map;

public class AppiumIosDriverStrategy implements IDriverStrategy {
    protected WebDriver iosDriver;
    private Map<String, String> iosCapabilities;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    AppiumIosDriverStrategy(MobileConfigModel mobileConfigModel) {
        iosCapabilities = Json.convertCapabilitiesToMap(mobileConfigModel.getCapabilities());
    }

    @Override
    public void initDriver() {
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();

        if (iosCapabilities != null) {
            for (Map.Entry<String, String> capability : iosCapabilities.entrySet()) {
                xcuiTestOptions.setCapability(capability.getKey(), capability.getValue());
            }
        } else {
            xcuiTestOptions.setNewCommandTimeout(Duration.ofSeconds(120));
            xcuiTestOptions.setPlatformName("IOS");
            xcuiTestOptions.setAutomationName("XCUITest");
            xcuiTestOptions.setNoReset(true);
        }

        try {
            LOGGER.info("Init IOS Driver");
            this.iosDriver = new IOSDriver(new URI("http://127.0.0.1:4723/wd/hub").toURL(), xcuiTestOptions);
        } catch (Exception e) {
            throw new RuntimeException("Error init IOS Driver", e);
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.iosDriver;
    }
}