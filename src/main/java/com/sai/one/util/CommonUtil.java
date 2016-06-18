package com.sai.one.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.one.constants.ErrorConstants;
import com.sai.one.exception.YedavaRunTimeException;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by shravan
 */

@Component
public class CommonUtil {

    public <T> T fromJSONtoObj(final byte[] userBytes, Class<T> type) {
        try {
            return (T) new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), type.getClass());
        } catch (IOException e) {
            throw new YedavaRunTimeException(ErrorConstants.JSON_TO_OBJECT.getCode(), ErrorConstants.JSON_TO_OBJECT.getMessage(), e.getCause());
        }
    }

    public <T> byte[] objToJson(T object) {
        try {
            return new ObjectMapper().writeValueAsBytes(object);
        } catch (JsonProcessingException exception) {
            throw new YedavaRunTimeException(ErrorConstants.JSON_PROCESSING.getCode(), ErrorConstants.JSON_PROCESSING.getMessage(), exception.getCause());
        }
    }

    public String generateRandomUUID() {
        StringBuilder randomUUIDBuilder = new StringBuilder(UUID.randomUUID().toString());
        return randomUUIDBuilder.toString();
    }
}
