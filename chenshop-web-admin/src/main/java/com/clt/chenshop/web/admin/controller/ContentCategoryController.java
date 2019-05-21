package com.clt.chenshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.SortUtils;
import com.clt.chenshop.common.pojo.TbContentCategory;
import com.clt.chenshop.service.admin.api.ContentCategoryService;
import com.clt.chenshop.service.admin.api.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-06 17:00
 **/
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController {

    @Reference(version = DubboVersionConstant.DUBBO_CONTENT_CATEGORY_SERVICE_VERSION)
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> dataList = new ArrayList<>();
        List<TbContentCategory> contentCategoryList = new ArrayList<>();
        getContentCategoryList(0L,contentCategoryList);
        SortUtils.sortContentCategoryList(dataList,contentCategoryList,0L,true);
        model.addAttribute("list",dataList);
        return "contentCategory";
    }

    @ResponseBody
    @RequestMapping(value = "tree")
    public List<TbContentCategory> getTreeData(@RequestParam(required = true,defaultValue = "0")long id){
        return contentCategoryService.getContentCategoryList(id);
    }

    private void getContentCategoryList(Long parentId,List<TbContentCategory> dataList){
        List<TbContentCategory> contentCategoryList = contentCategoryService.getContentCategoryList(parentId);
        dataList.addAll(contentCategoryList);
        for (TbContentCategory tbContentCategory : contentCategoryList) {
            if (tbContentCategory.getIsParent()){
                getContentCategoryList(tbContentCategory.getId(),dataList);
            }
        }
    }

}
