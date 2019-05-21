package com.clt.chenshop.service.admin.api;

import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbItem;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 商品管理接口
 */
public interface ItemService {
    /**
     * 商品分页查询
     * @return
     */
    public PageInfo<TbItem> getItemList(int pageNum,int pageSize);

    public BaseResult save(TbItem tbItem,String itemDesc);
}
