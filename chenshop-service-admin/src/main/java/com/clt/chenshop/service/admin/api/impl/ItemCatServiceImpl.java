package com.clt.chenshop.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.mapper.TbItemCatMapper;
import com.clt.chenshop.common.mapper.TbItemMapper;
import com.clt.chenshop.common.pojo.TbItemCat;
import com.clt.chenshop.service.admin.api.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import java.util.List;

@Service(version = DubboVersionConstant.DUBBO_ITEM_CAT_SERVICE_VERSION)
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getItemCatList(Long parentId) {
        Example example = new Example(TbItemCat.class);
        example.createCriteria().andEqualTo("parentId",parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
        return tbItemCats;
    }
}
