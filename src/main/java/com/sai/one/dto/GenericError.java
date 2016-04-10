package com.sai.one.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenericError implements Entity {

    @JsonProperty("error_message")
    private List<? extends Object> message;

    public List<? extends Object> getMessage() {
        return message;
    }

    public void setMessage(List<? extends Object> message) {
        this.message = message;
    }


}
