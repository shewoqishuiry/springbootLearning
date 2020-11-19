package com.example.builddream.utils;

public enum UserManagerErrorCodeEnum implements ErrorCode{

    SUCCESS("0","SUCCESS"),
    LOGING_INFO_ERROR("0x0001000","login info error."),
    REGISTER_ERROR_FAIL("0x0001002","Register new user failed."),
    MODIFY_USER_FAIL("0x0001003","Modify user information failed."),
    USER_NAME_AND_USER_ID_NOT_MATCH("0x0001005","UserId and username not match."),
    REMOVE_USER_FAIL("0x0001006","Delete user fail."),
    USER_ID_NOT_EXIST("0x0001007","User id not exist."),
    USER_NAME_NOT_EXIST("0x0001008","Username not exist."),
    USER_NAME_HAS_ALREADY_EXIST("0x0001007","Username has already exist.");

    private String code;
    private String message;

    UserManagerErrorCodeEnum(String code){
        this.code = code;
    }

    UserManagerErrorCodeEnum(String code, String message){
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
