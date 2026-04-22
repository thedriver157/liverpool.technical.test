package com.liverpool.Config;

import com.liverpool.Models.MobileConfigModel;
import com.liverpool.Utils.File;
import com.liverpool.Utils.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoadConfig {

    private static final String loadConfigProperty = System.getProperty("loadConfig");
    private static MobileConfigModel mobileConfigModel;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static MobileConfigModel getMobileConfigModel() {
        if (mobileConfigModel == null) {
            mobileConfigModel = Json.deserializeFromFileContent(loadConfigProperty, File.getJsonFromResources(String.format("cfg/%s.json", loadConfigProperty)), MobileConfigModel.class);
            assert mobileConfigModel != null;
            LOGGER.debug("Config Loaded: '{}' in file: '{}'", mobileConfigModel.getPlatform(), loadConfigProperty);
        }

        return mobileConfigModel;
    }
}