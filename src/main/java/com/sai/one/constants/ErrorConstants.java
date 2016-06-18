package com.sai.one.constants;

/**
 * Created by shravan
 */
public enum ErrorConstants {

    JSON_PROCESSING(5000, "cannot convert to json"),
    JSON_TO_OBJECT(5001, "cannot convert to object");

    ErrorConstants(int code, String message) {

    }


    private int code;
    private String message;

    public String getMessage() {
        return message;
    }

    public ErrorConstants setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ErrorConstants setCode(int code) {
        this.code = code;
        return this;
    }

}
