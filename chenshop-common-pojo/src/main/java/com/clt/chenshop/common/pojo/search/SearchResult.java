package com.clt.chenshop.common.pojo.search;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-26 15:43
 **/

@Data
public class SearchResult implements Serializable {
    // 商品列表
    private List<Item> itemList;
    // 总记录数
    private long recordCount;
    // 总页数
    private long pageCount;
    // 当前页
    private long curPage;
}
