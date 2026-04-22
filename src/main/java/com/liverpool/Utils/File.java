package com.liverpool.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.charset.StandardCharsets;

public class File {
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    public static String getJsonFromResources(String fileName) {
        try(InputStream inputStream = Json.class.getClassLoader().getResourceAsStream(fileName)) {

            if (inputStream == null) {
                throw new IllegalArgumentException(String.format("File not found in resources: %s", fileName));
            }

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.error("Error loading file: {}", e.toString());
            return null;
        }
    }
}