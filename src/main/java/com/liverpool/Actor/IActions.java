package com.liverpool.Actor;

import com.liverpool.Driver.MobileDriverManager;
import com.liverpool.Interfaces.IDriverStrategy;
import com.liverpool.Models.MobileConfigModel;
import com.liverpool.Utils.MobileElement;
import com.liverpool.Utils.Reflection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class IActions {

    private static MobileConfigModel mobileConfigModel;
    protected static ThreadLocal<IDriverStrategy> driverStrategy;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    public IActions(MobileConfigModel mobileConfigModel, MobileDriverManager mobileDriverManager) {
        IActions.mobileConfigModel = mobileConfigModel;
        IActions.driverStrategy = mobileDriverManager.initDriver(mobileConfigModel);
    }

    public void closeDriver() {
        driverStrategy.get().getDriver().quit();
    }

    public <T> T initPage(Class<T> genericPage) {
        return Reflection.createInstancePage(genericPage, I.get());
    }

    public void tap(MobileElement mobileElement) {
        LOGGER.debug("Tap");
        WebElement webElement = mobileElement.locatorResolve(driverStrategy.get().getDriver());
        webElement.click();
    }

    public void fillField(MobileElement mobileElement, String text) {
        LOGGER.debug("Fill Field");
        WebElement webElement = mobileElement.locatorResolve(driverStrategy.get().getDriver());
        webElement.sendKeys(text);
    }

    public List<WebElement> grabAllElements(MobileElement mobileElement) {
        LOGGER.debug("Grab All Elements");
        return mobileElement.locatorsResolve(driverStrategy.get().getDriver());
    }

    public void pressKey(Object key) {
        if (driverStrategy.get().getDriver() instanceof AndroidDriver) {
            LOGGER.debug("Android PressKey");
            ((AndroidDriver) driverStrategy.get().getDriver()).pressKey(new KeyEvent((AndroidKey) key));
        } else {
            LOGGER.debug("IOS PressKey");
            //IOS implementation
        }
    }

    public void scrollDown() {
        Dimension size = driverStrategy.get().getDriver().manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);

        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver) driverStrategy.get().getDriver()).perform(Arrays.asList(scroll));
    }

    private <T> void waitFor(ExpectedCondition<T> expectedCondition, int timeout) {
        new WebDriverWait(driverStrategy.get().getDriver(), Duration.ofSeconds(timeout))
                .until(expectedCondition);
    }

    private <T> void waitForRefreshed(ExpectedCondition<T> expectedCondition, int timeout) {
        new WebDriverWait(driverStrategy.get().getDriver(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.refreshed(
                        expectedCondition
                ));
    }

    public void waitForTime() {
        this.waitForTime(mobileConfigModel.getTimeout());
    }

    public void waitForTime(int timeout) {
            try {
                LOGGER.debug("Wait For Time");
                Thread.sleep(timeout * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    }

    public void waitForVisible(MobileElement mobileElement) {
        this.waitForVisible(mobileElement, mobileConfigModel.getTimeout());
    }

    public void waitForVisible(MobileElement mobileElement, int timeout) {
        LOGGER.debug("Wait For Visible");
        waitFor(ExpectedConditions.visibilityOf(mobileElement.locatorResolve(driverStrategy.get().getDriver())), timeout
        );
    }

    public void waitForDisplayed(MobileElement mobileElement) {
        this.waitForDisplayed(mobileElement, mobileConfigModel.getTimeout());
    }

    public void waitForDisplayed(MobileElement mobileElement, int timeout) {
        LOGGER.debug("Wait For Displayed");
        waitFor(isDisplay -> mobileElement.locatorResolve(driverStrategy.get().getDriver()).isDisplayed(), timeout);
    }

    public void waitForVisibleRefreshed(MobileElement mobileElement) {
        this.waitForVisibleRefreshed(mobileElement, mobileConfigModel.getTimeout());
    }

    public void waitForVisibleRefreshed(MobileElement mobileElement, int timeout) {
        waitForRefreshed(ExpectedConditions.visibilityOf(mobileElement.locatorResolve(driverStrategy.get().getDriver())), timeout);
    }

    public void waitForElementToBeClickable(MobileElement mobileElement) {
        this.waitForElementToBeClickable(mobileElement, mobileConfigModel.getTimeout());
    }

    public void waitForElementToBeClickable(MobileElement mobileElement, int timeout) {
        waitFor(ExpectedConditions.elementToBeClickable(mobileElement.locatorResolve(driverStrategy.get().getDriver())), timeout);
    }
}