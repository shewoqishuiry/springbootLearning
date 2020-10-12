package com.example.builddream.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(
        description = "返回数据对象"
)
public class BaseResponse<T> {
    @ApiModelProperty(
            value = "错误码",
            example = "0"
    )
    private String code;

    @ApiModelProperty(
            value = "错误描述",
            example = "success"
    )
    private String message;

    @ApiModelProperty(
            value = "具体数据",
            example = "Object"
    )
    private T data;

    public BaseResponse(){
        this.code = CommonErrorCodeEnum.SUCCESS.getCode();
        this.message = CommonErrorCodeEnum.SUCCESS.getMessage();
    }

    public BaseResponse(T data){
        this.code = CommonErrorCodeEnum.SUCCESS.getCode();
        this.message = CommonErrorCodeEnum.SUCCESS.getMessage();
        this.data = data;
    }

    public BaseResponse(String code,String message){
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code,String message,T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public BaseResponse(ErrorCode errorCode,T data) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setErrorCodeEnum(ErrorCode errorCodeEnum){
        this.code = errorCodeEnum.getCode();
        this.message =  errorCodeEnum.getMessage();
    }
}
