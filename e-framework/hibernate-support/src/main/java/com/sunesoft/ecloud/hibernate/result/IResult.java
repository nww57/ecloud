package com.sunesoft.ecloud.hibernate.result;

import java.io.Serializable;
import java.util.Map;

public interface IResult<T> extends Serializable {

    Boolean getIs_success();

    void setIs_success(Boolean is_success);

    String getMessage();

    void setMessage(String message);

    T getResult();

    void setResult(T result);


    Map<String, Object> getUserData();

    void setUserData(Map<String, Object> userData);

    void putUserData(String key, Object value);

}
