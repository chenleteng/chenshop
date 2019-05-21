package com.clt.chenshop.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.constant.ResponseConstant;
import com.clt.chenshop.common.mapper.TbContentMapper;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbContent;
import com.clt.chenshop.common.utils.IDUtils;
import com.clt.chenshop.service.admin.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-10 18:35
 **/

@Service(version = DubboVersionConstant.DUBBO_CONTENT_SERVICE_VERSION)
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> getContentList(Long categoryId) {
        Example example = new Example(TbContent.class);
        if (categoryId != null && categoryId != 0L){
            example.createCriteria().andEqualTo("categoryId",categoryId);
        }
        List<TbContent> tbContents = tbContentMapper.selectByExample(example);
        return tbContents;
    }

    @Override
    public TbContent getById(Long id) {
        TbContent tbContent = tbContentMapper.selectByPrimaryKey(id);
        return tbContent;
    }

    @Override
    public BaseResult save(TbContent tbContent) {
        BaseResult baseResult = null;

        int result = 0;

        tbContent.setUpdated(new Date());
        if (tbContent.getId() == null || tbContent.getId() == 0){
            tbContent.setId(IDUtils.genId());
            tbContent.setCreated(new Date());
            System.out.println(tbContent.getCategoryId());
            result = tbContentMapper.insert(tbContent);
        }else {
            result = tbContentMapper.updateByPrimaryKey(tbContent);
        }

        if (result > 0){
            baseResult  = BaseResult.build(ResponseConstant.Ok,ResponseConstant.SAVE_CONTENT_MSG_OK);
        } else {
            baseResult  = BaseResult.build(ResponseConstant.SAVE_CONTENT_STATUS_FAIL,ResponseConstant.SAVE_CONTENT_MSG_FAIL);
        }

        return baseResult;
    }
}
