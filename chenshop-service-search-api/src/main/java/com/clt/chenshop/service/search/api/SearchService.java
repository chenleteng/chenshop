package com.clt.chenshop.service.search.api;

import com.clt.chenshop.common.pojo.search.SearchResult;

public interface SearchService {
    public SearchResult search(String queryString, int page, int rows) throws Exception;
}
