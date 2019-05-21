package com.clt.chenshop.service.admin.api;

import com.clt.chenshop.common.pojo.TbItemCat;

import java.util.List;

/**
 * 商品分类
 */
public interface ItemCatService {
    public List<TbItemCat> getItemCatList(Long parentId);
}
