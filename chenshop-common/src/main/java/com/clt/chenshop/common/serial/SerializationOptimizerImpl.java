package com.clt.chenshop.common.serial;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.alibaba.fastjson.JSONObject;
import com.clt.chenshop.common.pojo.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl  implements SerializationOptimizer {
    @Override
    public Collection<Class> getSerializableClasses() {
        // 添加需要序列化的类
        List<Class> classes = new LinkedList<Class>();
        classes.add(JSONObject.class);
        classes.add(BaseResult.class);
        classes.add(TbContent.class);
        classes.add(TbContentCategory.class);
        classes.add(TbItem.class);
        classes.add(TbItemCat.class);
        classes.add(TbItemDesc.class);
        classes.add(TbItemParam.class);
        classes.add(TbItemParamItem.class);
        classes.add(TbOrder.class);
        classes.add(TbOrderItem.class);
        classes.add(TbOrderShipping.class);
        classes.add(TbUser.class);
        classes.add(BaseEntity.class);
        return classes;
    }
}
