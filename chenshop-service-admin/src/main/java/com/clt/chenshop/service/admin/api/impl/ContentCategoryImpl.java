package com.clt.chenshop.service.admin.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.mapper.TbContentCategoryMapper;
import com.clt.chenshop.common.pojo.TbContentCategory;
import com.clt.chenshop.service.admin.api.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-06 17:10
 **/
@Service(version = DubboVersionConstant.DUBBO_CONTENT_CATEGORY_SERVICE_VERSION)
public class ContentCategoryImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbContentCategory> getContentCategoryList(Long parentId) {
        Example example = new Example(TbContentCategory.class);
        example.createCriteria().andEqualTo("parentId",parentId);
        List<TbContentCategory> contentCategorys = tbContentCategoryMapper.selectByExample(example);
        return contentCategorys;
    }
}
