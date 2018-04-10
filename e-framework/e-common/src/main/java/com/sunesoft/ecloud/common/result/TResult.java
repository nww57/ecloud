package com.sunesoft.ecloud.common.result;

import java.util.HashMap;
import java.util.Map;

public class TResult<T> implements IResult<T>{
    private Boolean is_success;

    private Long statusCode=200L;

    private String message ="";

    private T result;

    private Map<String,Object> userData = new HashMap<>();

    public TResult(){}
    public TResult(T t){
        is_success = true;
        this.result = t;
    }
    public TResult(String message){
        is_success = false;
        this.message = message;
    }
    public TResult(boolean is_success,String message){
        this.is_success = is_success;
        this.message = message;
    }

    public Boolean getIs_success() {
        return is_success;
    }

    public void setIs_success(Boolean is_success) {
        this.is_success = is_success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Map<String, Object> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, Object> userData) {
        this.userData = userData;
    }

    public void putUserData(String key, Object value) {
        userData.put(key,value);
    }

    @Override
    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }
}
