package com.example.builddream.utils;

public enum CommonErrorCodeEnum implements ErrorCode {
    SUCCESS("0","SUCCESS"),
    LOGING_INFO_ERROR("0x0001000","login info error."),
    REGISTER_NAME_DUPLICATED("0x0001001","The register name duplicated."),
    REGISTER_ERROR_FAIL("0x0001002","Register new user failed."),
    MODIFY_USER_FAIL("0x0001003","Modify user information failed."),
    UNREGISTER_USER_FAIL("0x0001004","Unregister user failed."),
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

    public String getCode(){
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
