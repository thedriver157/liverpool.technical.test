package com.liverpool.Driver;

import com.liverpool.Interfaces.IDriverStrategy;
import com.liverpool.Models.MobileConfigModel;

import java.util.Map;

public class MobileDriverManager {
    private final Map<String, IDriverStrategy> mobileDriverStrategyMap;
    private static final ThreadLocal<IDriverStrategy> driverStrategy = new ThreadLocal<>();

    public MobileDriverManager(Map<String, IDriverStrategy> mobileDriverStrategyMap) {
        this.mobileDriverStrategyMap = mobileDriverStrategyMap;
    }

    public ThreadLocal<IDriverStrategy> initDriver(MobileConfigModel mobileConfigModel) {
        IDriverStrategy driverStrategy = null;

        if (mobileConfigModel.getPlatform().equalsIgnoreCase("android")) {
            driverStrategy = mobileDriverStrategyMap.get("ANDROID");
        } else {
            driverStrategy = mobileDriverStrategyMap.get("IOS");
        }

        if (driverStrategy == null) {
            throw new IllegalArgumentException(String.format("Platform not supported: %s", mobileConfigModel.getPlatform()));
        }

        driverStrategy.initDriver();
        MobileDriverManager.driverStrategy.set(driverStrategy);

        return MobileDriverManager.driverStrategy;
    }
}