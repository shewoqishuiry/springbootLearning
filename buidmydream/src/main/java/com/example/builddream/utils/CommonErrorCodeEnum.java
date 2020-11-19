package com.example.builddream.utils;

public enum CommonErrorCodeEnum implements ErrorCode {
    SUCCESS("0","SUCCESS"),

    REQUEST_PARAM_MISSING("0x0007200","The required parameter %s is blank."),
    REQUEST_PARAM_OUT_RANGE("0x0007201","The required parameter %s is out of range.");

    private String code;
    private String message;

    CommonErrorCodeEnum(String code){
        this.code = code;
    }

    CommonErrorCodeEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode(){
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
