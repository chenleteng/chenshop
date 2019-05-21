package com.clt.chenshop.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.constant.ResponseConstant;
import com.clt.chenshop.common.mapper.TbItemDescMapper;
import com.clt.chenshop.common.mapper.TbItemMapper;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbItem;
import com.clt.chenshop.common.pojo.TbItemDesc;
import com.clt.chenshop.common.utils.IDUtils;
import com.clt.chenshop.service.admin.api.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service(version = DubboVersionConstant.DUBBO_ITEM_SERVICE_VERSION)
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbItemDescMapper tbItemDescMapper;

    @Override
    public PageInfo<TbItem> getItemList(int pageNum,int pageSize) {
        Example example = new Example(TbItem.class);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItemMapper.selectByExample(example));
        return pageInfo;
    }

    @Override
    public BaseResult save(TbItem tbItem, String itemDesc) {
        BaseResult result = new BaseResult();

        tbItem.setId(IDUtils.genId());
        tbItem.setStatus((byte)1);
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());

        int insert = tbItemMapper.insert(tbItem);

        if (insert > 0){
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(tbItem.getId());
            tbItemDesc.setCreated(new Date());
            tbItemDesc.setUpdated(new Date());
            tbItemDescMapper.insert(tbItemDesc);

            result.setStatus(ResponseConstant.SAVE_ITEM_STATUS_OK);
            result.setMsg(ResponseConstant.SAVE_ITEM_MSG_OK);
            return result;
        }

        result.setStatus(ResponseConstant.SAVE_ITEM_STATUS_FAIL);
        result.setMsg(ResponseConstant.SAVE_ITEM_MSG_FAIL);
        return result;
    }
}
