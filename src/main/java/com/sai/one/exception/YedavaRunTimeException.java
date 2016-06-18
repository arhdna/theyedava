package com.sai.one.exception;

/**
 * Created by shravan
 */
public class YedavaRunTimeException extends RuntimeException{

    private int code;
    private String message;

    public YedavaRunTimeException(){
        super();
    }

    public YedavaRunTimeException(int code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
