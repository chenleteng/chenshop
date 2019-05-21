package com.clt.chenshop.web.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.TbContent;
import com.clt.chenshop.portal.api.ContentService;
import com.clt.chenshop.web.portal.controller.dto.BigAD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-26 15:32
 **/

@Controller
public class indexController {

    @Value(value = "classpath:category.json")
    private Resource resourceCategory;

    @Reference(version = DubboVersionConstant.DUBBO_CONTENT_SERVICE_VERSION)
    private ContentService contentService;

    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("bigAD",getBigAd());
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "category",method = RequestMethod.GET)
    public Resource category(){
        return resourceCategory;
    }

    private List<BigAD> getBigAd(){
        List<BigAD> bigADList = new ArrayList<>();
        List<TbContent> contentList = contentService.getBigAD();

        for (TbContent tbContent : contentList) {
            BigAD bigAD = new BigAD();
            bigAD.setSrc(tbContent.getPic());
            bigAD.setWidth(670);
            bigAD.setHeight(240);
            bigAD.setSrcB(tbContent.getPic());
            bigAD.setWidthB(550);
            bigAD.setHeightB(670);
            bigAD.setAlt(tbContent.getSubTitle());
            bigAD.setHref(tbContent.getUrl());
            bigADList.add(bigAD);
        }

        return bigADList;
    }
}
