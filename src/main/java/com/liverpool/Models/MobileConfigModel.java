package com.liverpool.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MobileConfigModel {
    private boolean isRemote;
    private String remoteUrl;
    private String platform;
    private String deviceName;
    private int timeout = 60;
    private Capabilities capabilities;

    @JsonProperty("isRemote")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public boolean isRemote() {
        return isRemote;
    }

    @JsonProperty("isRemote")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    @JsonProperty("remoteUrl")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getRemoteUrl() {
        return remoteUrl;
    }

    @JsonProperty("remoteUrl")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    @JsonProperty("platform")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setPlatform(String platform) {
        this.platform = platform;
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

    @JsonProperty("timeout")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Capabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }
}