package com.sunesoft.ecloud.hibernate.result.resultFactory;

import com.sunesoft.ecloud.hibernate.result.IResult;
import com.sunesoft.ecloud.hibernate.result.ListResult;
import com.sunesoft.ecloud.hibernate.result.PagedResult;
import com.sunesoft.ecloud.hibernate.result.TResult;

import java.util.List;

public class ResultFactory {

    public static IResult success() {
        return new TResult(true, "");
    }


    public static <T> IResult success(T t) {
        return new TResult(t);
    }

    public static IResult error(String message)
    {
        return new TResult(message);
    }


    public static <T> ListResult<T> listResult(List<T> list) {
        return new ListResult<>(list);
    }


    public static <T> PagedResult<T> pagedResult(List<T> items, int pageIndex, int pageSize, int totalItemsCount){
        return  new PagedResult<>(items,pageIndex,pageSize,totalItemsCount);
    }

    public static <T> PagedResult<T> pagedError(int pageIndex, int pageSize, String message){
        return  new PagedResult<>(pageIndex,pageSize,message);
    }
}
