package com.liverpool.Driver;

import com.liverpool.Interfaces.IDriverStrategy;
import com.liverpool.Models.MobileConfigModel;
import com.liverpool.Utils.Json;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.time.Duration;
import java.util.Map;

public class AppiumAndroidDriverStrategy implements IDriverStrategy {
    protected WebDriver androidDriver;
    private MobileConfigModel mobileConfigModel;
    private Map<String, String> androidCapabilities;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    AppiumAndroidDriverStrategy(MobileConfigModel mobileConfigModel) {
        this.mobileConfigModel = mobileConfigModel;
        androidCapabilities = Json.convertCapabilitiesToMap(mobileConfigModel.getCapabilities());
    }

    @Override
    public void initDriver() {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();

        if (androidCapabilities != null) {
            for (Map.Entry<String, String> capability : androidCapabilities.entrySet()) {
                uiAutomator2Options.setCapability(capability.getKey(), capability.getValue());
            }
        } else {
            uiAutomator2Options.setNewCommandTimeout(Duration.ofSeconds(120));
            uiAutomator2Options.setPlatformName("Android");
            uiAutomator2Options.setDeviceName("emulator-5554");
            uiAutomator2Options.setAutomationName("UiAutomator2");
            uiAutomator2Options.setNoReset(true);
        }

        try {
            LOGGER.info("Init Android Driver");
            this.androidDriver = new AndroidDriver(
                    this.mobileConfigModel.isRemote()
                            ? new URI(this.mobileConfigModel.getRemoteUrl()).toURL()
                            : new URI("http://127.0.0.1:4723/wd/hub").toURL(),
                    uiAutomator2Options);
        } catch (Exception e) {
            throw new RuntimeException("Error init Android Driver", e);
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.androidDriver;
    }
}