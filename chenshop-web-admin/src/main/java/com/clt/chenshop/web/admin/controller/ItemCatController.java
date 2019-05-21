package com.clt.chenshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.TbItemCat;
import com.clt.chenshop.service.admin.api.ItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "itemCat")
public class ItemCatController {
    @Reference(version = DubboVersionConstant.DUBBO_ITEM_CAT_SERVICE_VERSION)
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping(value = "list")
    public List<TbItemCat> list(@RequestParam(required = true,defaultValue = "0") Long id){
        List<TbItemCat> itemCatList = itemCatService.getItemCatList(id);
        return itemCatList;
    }
}
