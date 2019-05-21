package com.clt.chenshop.api.controller.v1;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clt.chenshop.api.controller.dto.ItemCatDTO;
import com.clt.chenshop.api.controller.dto.ItemCatNode;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.pojo.TbItemCat;
import com.clt.chenshop.service.admin.api.ItemCatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-26 18:06
 **/

@RestController
@RequestMapping(value = "${api.path.v1}/item/cat")
public class itemCatApiV1Controller {

    @Reference(version = DubboVersionConstant.DUBBO_ITEM_CAT_SERVICE_VERSION)
    private ItemCatService itemCatService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ItemCatDTO<ItemCatNode> list(){
        ItemCatDTO<ItemCatNode> dto = new ItemCatDTO<>();
        List itemCatList =  getItemCatList(0L);
        dto.setData(itemCatList);
        return dto;
    }

    public List getItemCatList(Long parentId){
        List dataList = new ArrayList<>();
        List<TbItemCat> tbItemCat = itemCatService.getItemCatList(parentId);

        for (TbItemCat itemCat : tbItemCat) {
            ItemCatNode itemCatNode = new ItemCatNode();

            if (itemCat.getIsParent()){
                if (itemCat.getParentId() == 0){
                    itemCatNode.setName(String.format("<a href='/products/%s.html'>%s</a>",itemCat.getId(),itemCat.getName()));
                }else {
                    itemCatNode.setName(itemCat.getName());
                }
                itemCatNode.setUrl(String.format("/products/%s.html",itemCat.getId()));
                itemCatNode.setItem(getItemCatList(itemCat.getId()));

                dataList.add(itemCatNode);
            }

            else {
                dataList.add(String.format("/products/%s.html|%s",itemCat.getId(),itemCat.getName()));
            }
        }
        return dataList;
    }
}
