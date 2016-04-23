package com.sai.one.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenericError implements Entity {

    @JsonProperty("error_message")
    private List<?> message;

    public List<?> getMessage() {
        return message;
    }

    public void setMessage(List<?> message) {
        this.message = message;
    }


}
