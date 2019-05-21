package com.clt.chenshop.service.search.dao;

import com.clt.chenshop.common.pojo.search.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

public interface SearchDao {
    public SearchResult search(SolrQuery query) throws Exception;
}
