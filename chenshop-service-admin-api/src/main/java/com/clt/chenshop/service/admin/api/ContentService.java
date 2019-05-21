package com.clt.chenshop.service.admin.api;

import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbContent;
import com.clt.chenshop.common.pojo.TbContentCategory;

import java.util.List;

public interface ContentService {
    public List<TbContent> getContentList(Long categoryId);

    public TbContent getById(Long id);

    public BaseResult save(TbContent tbContent);
}
