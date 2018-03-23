package com.sunesoft.ecloud.hibernate.result;

import java.util.ArrayList;
import java.util.List;

public class ListResult<T> extends TResult<List<T>> implements IResult<List<T>> {


    public ListResult(){}

    public ListResult(List<T> list){
        this.setResult(list);
        setIs_success(true);
    }

    public ListResult(String errorMsg){
        this.setResult(new ArrayList<T>());
        setIs_success(false);
        setMessage(errorMsg);
    }
}
