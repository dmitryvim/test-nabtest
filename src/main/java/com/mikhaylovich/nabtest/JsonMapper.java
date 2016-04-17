package com.mikhaylovich.nabtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonMapper {
    private static ObjectMapper SERVICE_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * @return map JSON to DTO objects, skip fields in JSON which are not valueType fields
     */
    public static <T> T parseJson(String json, Class<T> valueType) {
        try {
            return SERVICE_MAPPER.treeToValue(SERVICE_MAPPER.readTree(json), valueType);
        } catch (IOException e) {
            throw new RuntimeException("cannot map JSON to " + valueType.getName(), e);
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
