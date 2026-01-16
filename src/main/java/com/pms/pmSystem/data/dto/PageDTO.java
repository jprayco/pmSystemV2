package com.pms.pmSystem.data.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = -5371201158843795779L;

    private boolean hasNextPage;

    private long totalElements;

    private List<T> results;

    private int currentPage;

    private int pageSize;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public PageDTO<T> setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public PageDTO<T> setTotalElements(long totalElements) {
        this.totalElements = totalElements;
        return this;
    }

    public List<T> getResults() {
        return results;
    }

    public PageDTO<T> setResults(List<T> results) {
        this.results = results;
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PageDTO<T> setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageDTO<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public static <Y, Z> PageDTO<Z> newPageInfo(Page<Y> paged, List<Z> list) {
        return new PageDTO<Z>().setResults(list)
                .setCurrentPage(paged.getNumber())
                .setTotalElements(paged.getTotalElements())
                .setHasNextPage(paged.hasNext())
                .setPageSize(paged.getSize());

    }

    public static <Y, Z> PageDTO<Z> emptyPageInfo() {
        return new PageDTO<Z>().setResults(Collections.emptyList());
    }
}
