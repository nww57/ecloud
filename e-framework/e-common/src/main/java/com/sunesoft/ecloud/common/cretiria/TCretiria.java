package com.sunesoft.ecloud.common.cretiria;

import java.util.HashMap;
import java.util.Map;

public  class TCretiria {
    private static final long serialVersionUID = 1L;
    private Integer pageIndex =1;
    private Integer pageSize = 20;
    private Map<String, Object> params = new HashMap<>();
    private String orderBy;
    private OrderTurn  orderTurn;

    public Integer getStartIndex(){
        return (pageIndex-1)*pageSize;
    }


    public Integer getEndIndex(){
        return pageIndex*pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public OrderTurn getOrderTurn() {
        return orderTurn;
    }

    public void setOrderTurn(OrderTurn orderTurn) {
        this.orderTurn = orderTurn;
    }
}
