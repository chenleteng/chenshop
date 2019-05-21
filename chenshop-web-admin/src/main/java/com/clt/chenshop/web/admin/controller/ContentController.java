package com.clt.chenshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbContent;
import com.clt.chenshop.service.admin.api.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-10 17:34
 **/

@Controller
@RequestMapping(value = "content")
public class ContentController {

    @Reference(version = DubboVersionConstant.DUBBO_CONTENT_SERVICE_VERSION)
    private ContentService contentService;

    @ModelAttribute
    public TbContent initModel(Long id){
        TbContent entity = contentService.getById(id);
        if (entity == null){
            entity = new TbContent();
        }
        return entity;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "contentList";
    }

    @RequestMapping(value = "from",method = RequestMethod.GET)
    public String from(){
        return "contentFrom";
    }

    @RequestMapping(value = "save")
    public  String save(TbContent tbContent,Model model){
        BaseResult baseResult = contentService.save(tbContent);
        model.addAttribute("result",baseResult);
        return list();
     }

    @ResponseBody
    @RequestMapping(value = "getTableData")
    public Map<String,Object> getTableData (Long categoryId){
        Map<String,Object> map = new HashMap<>();
        map.put("aData",contentService.getContentList(categoryId));
        return map;
    }

}
