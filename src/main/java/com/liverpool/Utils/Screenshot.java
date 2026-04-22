package com.liverpool.Utils;

import io.qameta.allure.Allure;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    static Path mainPath = Paths.get(System.getProperty("user.dir")).getParent();
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static void takeScreenshot(byte[] screenshotBytes, String screenshotName) {
        try {
            String fileName = String.format("%s/SS/Execution_%s_%s/Execution_%s_%s.png",
                    mainPath,
                    screenshotName,
                    DateTime.now().toString("dd_MM_yyyy"),
                    screenshotName,
                    DateTime.now().toString("dd_MM_yyyy_HH_mm_ss")
            );

            Allure.addAttachment(fileName, new ByteArrayInputStream(screenshotBytes));
        } catch (Exception e) {
            LOGGER.error("Error saving screenshot: {}", screenshotName);
        }
    }
}