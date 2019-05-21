package com.clt.chenshop.web.search.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.search.SearchResult;
import com.clt.chenshop.service.search.api.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-27 14:42
 **/

@Controller
public class SearchController {

    @Reference(version = DubboVersionConstant.DUBBO_SEARCH_SERVICE_VERSION)
    private SearchService searchService;

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public BaseResult query(@RequestParam(name = "q") String queryString,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "60") int rows){
        SearchResult searchResult = null;
        try {
            searchResult = searchService.search(queryString,page,rows);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseResult.build(500,"网络不给力，请检查您的网络环境");
        }
        return BaseResult.ok(searchResult);
    }

}
