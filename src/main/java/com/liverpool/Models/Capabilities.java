package com.liverpool.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Capabilities {
    private long newCommandTimeout;
    private String deviceName;
    private String automationName;
    private boolean noReset;
    private String appPackage;
    private String appActivity;
    private String app;
    private String bundleId;
    private boolean autoGrantPermissions;
    private boolean autoAcceptAlerts;

    @JsonProperty("newCommandTimeout")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public long getNewCommandTimeout() {
        return newCommandTimeout;
    }

    @JsonProperty("newCommandTimeout")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setNewCommandTimeout(long newCommandTimeout) {
        this.newCommandTimeout = newCommandTimeout;
    }

    @JsonProperty("deviceName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("deviceName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @JsonProperty("automationName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAutomationName() {
        return automationName;
    }

    @JsonProperty("automationName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setAutomationName(String automationName) {
        this.automationName = automationName;
    }

    @JsonProperty("noReset")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public boolean isNoReset() {
        return noReset;
    }

    @JsonProperty("noReset")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setNoReset(boolean noReset) {
        this.noReset = noReset;
    }

    @JsonProperty("appPackage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppPackage() {
        return appPackage;
    }

    @JsonProperty("appPackage")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    @JsonProperty("appActivity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getAppActivity() {
        return appActivity;
    }

    @JsonProperty("appActivity")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    @JsonProperty("app")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getApp() {
        return app;
    }

    @JsonProperty("app")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setApp(String app) {
        this.app = app;
    }

    @JsonProperty("bundleId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getBundleId() {
        return bundleId;
    }

    @JsonProperty("bundleId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    @JsonProperty("autoGrantPermissions")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public boolean isAutoGrantPermissions() {
        return autoGrantPermissions;
    }

    @JsonProperty("autoGrantPermissions")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setAutoGrantPermissions(boolean autoGrantPermissions) {
        this.autoGrantPermissions = autoGrantPermissions;
    }

    @JsonProperty("autoAcceptAlerts")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public boolean isAutoAcceptAlerts() {
        return autoAcceptAlerts;
    }

    @JsonProperty("autoAcceptAlerts")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public void setAutoAcceptAlerts(boolean autoAcceptAlerts) {
        this.autoAcceptAlerts = autoAcceptAlerts;
    }
}