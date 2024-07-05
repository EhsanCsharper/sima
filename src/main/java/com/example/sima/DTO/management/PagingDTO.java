package com.example.sima.DTO.management;

import java.io.Serializable;

public class PagingDTO implements Serializable {
    private int pageIndex;
    private int pageSize;
    private String orderBy;

    public static int DEFAULT_PAGE_INDEX = 0;
    public static int DEFAULT_PAGE_SIZE = 2;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
