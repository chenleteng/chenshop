package com.clt.chenshop.service.admin.api;

import com.clt.chenshop.common.pojo.TbContentCategory;

import java.util.List;

public interface ContentCategoryService {
        public List<TbContentCategory> getContentCategoryList(Long parentId);
}
