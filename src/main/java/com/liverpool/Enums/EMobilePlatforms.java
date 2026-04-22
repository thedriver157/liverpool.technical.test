package com.liverpool.Enums;

public enum EMobilePlatforms {
    ANDROID("ANDROID"),
    IOS("IOS");

    private final String mobilePlatforms;

    EMobilePlatforms(String _mobilePlatforms) {
        this.mobilePlatforms = _mobilePlatforms;
    }

    public String getMobilePlatform() {
        return this.mobilePlatforms.toUpperCase();
    }
}