package com.sunesoft.ecloud.hibernate.result;

import java.util.ArrayList;
import java.util.List;

public class PagedResult<T> extends TResult<List<T>> implements IResult<List<T>> {


    public PagedResult(){
        this.setResult(new ArrayList<T>());
    }

    public PagedResult(int pageIndex, int pageSize,String message) {

        this.setIs_success(false);
        this.setMessage(message);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.setResult(new ArrayList<T>());
        pageCount = 0;
        totalCount = 0;
    }


    public PagedResult(List<T> items, int pageIndex, int pageSize, int totalItemsCount) {
        this.setIs_success(true);
        this.setResult(items);
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.pageCount = countPages(pageSize, totalItemsCount);
        this.totalCount = totalItemsCount;
    }

    private Integer pageIndex=1;

    private Integer pageSize=20;

    private Integer totalCount;

    private Integer pageCount;

    public Integer getPageIndex() {
        return pageIndex;
    }
    private int countPages(int size, int itemsCount) {
        return (int) Math.ceil((double) itemsCount / size);
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
