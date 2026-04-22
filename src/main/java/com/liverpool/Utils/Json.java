package com.liverpool.Utils;

import com.liverpool.Models.Capabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.core.StreamReadFeature;
import tools.jackson.core.json.JsonReadFeature;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.json.JsonMapper;

import java.lang.invoke.MethodHandles;
import java.util.Map;

public class Json {
    private static final JsonMapper jsonMapper;
    static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    static {
        jsonMapper = JsonMapper.builder()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION, true)
                .enable(JsonReadFeature.ALLOW_JAVA_COMMENTS)
                .build();
    }

    public static <T> T deserializeFromFileContent(String fileName, String fileContent, Class<T> clazz) {
        try {
            LOGGER.debug("Deserialize file: {}", fileName);
            return jsonMapper.readValue(fileContent, clazz);
        } catch (Exception e) {
            LOGGER.error("Error deserializing file: {}", e.toString());
            return null;
        }
    }

    public static Map<String, String> convertCapabilitiesToMap(Capabilities capabilities) {
        LOGGER.debug("Convert Capabilities to Map");
        String jsonCapabilities = jsonMapper.writeValueAsString(capabilities);
        return jsonMapper.readValue(jsonCapabilities, new TypeReference<Map<String, String>>() {});
    }
}