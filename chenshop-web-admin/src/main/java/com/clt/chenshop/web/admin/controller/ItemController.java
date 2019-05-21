package com.clt.chenshop.web.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.BaseResult;
import com.clt.chenshop.common.pojo.TbItem;
import com.clt.chenshop.common.pojo.TbItemCat;
import com.clt.chenshop.service.admin.api.ItemCatService;
import com.clt.chenshop.service.admin.api.ItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "item")
public class ItemController {

    @Reference(version = DubboVersionConstant.DUBBO_ITEM_SERVICE_VERSION)
    private ItemService itemService;

    @RequestMapping(value = "list")
    public String list(){
        return "itemList";
    }

    @ResponseBody
    @RequestMapping(value = "getTableData")
    public Map<String,Object> getTableData(Integer sEcho,Integer iDisplayStart ,Integer iDisplayLength){
        Map<String,Object> map = new HashMap<>();
        int pageNum = iDisplayStart / iDisplayLength + 1;
        PageInfo<TbItem> pageInfo = itemService.getItemList(pageNum,iDisplayLength);

        map.put("sEcho",sEcho + 1);
        map.put("iTotalRecords",pageInfo.getTotal());
        map.put("iTotalDisplayRecords",pageInfo.getTotal());
        map.put("aData",pageInfo.getList());

        return map;
    }

    @RequestMapping(value = "addItem")
    public String addItem(){
        return "addItem";
    }

    @RequestMapping(value = "save")
    public String save(TbItem tbItem, String itemDesc, Model model){
        BaseResult result =  itemService.save(tbItem,itemDesc);
        model.addAttribute("result",result);
        return "addItem";
    }

}
