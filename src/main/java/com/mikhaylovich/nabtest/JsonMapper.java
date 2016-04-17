package com.mikhaylovich.nabtest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonMapper {
    private static ObjectMapper SERVICE_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * (де)сериализация будет проходит с использованием полей, а не getterов и  setterов
     */
    static {
        SERVICE_MAPPER.setVisibilityChecker(SERVICE_MAPPER.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
    }

    /**
     * @return map JSON to DTO objects, skip fields in JSON which are not valueType fields
     */
    public static <T> T parseJson(String json, Class<T> valueType) {
        try {
            return SERVICE_MAPPER.readValue(json.getBytes(), valueType);
        } catch (IOException e) {
            throw new RuntimeException("cannot map JSON[" + json + "] to " + valueType.getName(), e);
        }
    }

    /**
     * convert dto object to json using its getters
     */
    public static <T> String convertToJson(T dto) {
        try {
            return SERVICE_MAPPER.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("cannot map " + dto.getClass().getName() + " class to Json", e);
        }
    }
}
