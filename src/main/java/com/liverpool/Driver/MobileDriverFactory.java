package com.liverpool.Driver;

import com.liverpool.Enums.EMobilePlatforms;
import com.liverpool.Interfaces.IDriverStrategy;
import com.liverpool.Models.MobileConfigModel;

import java.util.HashMap;
import java.util.Map;

public class MobileDriverFactory {

    @SuppressWarnings("unchecked")
    private static <T> T instanceMobileStrategy(EMobilePlatforms eMobilePlatforms, MobileConfigModel mobileConfigModel) {
        return switch (eMobilePlatforms.getMobilePlatform()) {
            case "ANDROID" -> (T) new AppiumAndroidDriverStrategy(mobileConfigModel);
            case "IOS" -> (T) new AppiumIosDriverStrategy(mobileConfigModel);
            default -> throw new IllegalStateException(String.format("Unexpected value: %s", eMobilePlatforms.getMobilePlatform()));
        };
    }

    public static MobileDriverManager createDriverManager(MobileConfigModel mobileConfigModel) {
        Map<String, IDriverStrategy> driverStrategyMap = new HashMap<>();

        EMobilePlatforms eMobilePlatforms = EMobilePlatforms.valueOf(mobileConfigModel.getPlatform().toUpperCase());
        driverStrategyMap.put(eMobilePlatforms.getMobilePlatform(), (IDriverStrategy) instanceMobileStrategy(eMobilePlatforms, mobileConfigModel));

        return new MobileDriverManager(driverStrategyMap);
    }
}