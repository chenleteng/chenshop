package com.clt.chenshop.service.portal.api.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.clt.chenshop.common.constant.DubboVersionConstant;
import com.clt.chenshop.common.mapper.TbContentMapper;
import com.clt.chenshop.common.pojo.SortUtils;
import com.clt.chenshop.common.pojo.TbContent;
import com.clt.chenshop.common.utils.FastJsonConvert;
import com.clt.chenshop.portal.api.ContentService;
import com.clt.chenshop.service.redis.api.JedisSentinel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-18 17:28
 **/
@Service(version = DubboVersionConstant.DUBBO_CONTENT_SERVICE_VERSION)
@Transactional
public class ContentServiceImpl implements ContentService {

    private static final String KEY_BIG_AD = "bigAD";

    @Autowired
    private TbContentMapper tbContentMapper;

    @Reference(version = DubboVersionConstant.DUBBO_JEDIS_CLIENT_SENTINEL_VERSION)
    private JedisSentinel jedisSentinel;

    @Override
    public List<TbContent> getBigAD() {

        String strBigADList = (String) jedisSentinel.get(KEY_BIG_AD);
        System.out.println(StringUtils.isNotBlank(strBigADList));
        if (StringUtils.isNotBlank(strBigADList)){
            System.out.println("come in");
            return FastJsonConvert.convertJSONToArray(strBigADList,TbContent.class);
        }

        Example example = new Example(TbContent.class);
        example.createCriteria().andEqualTo("categoryId",89);
        List<TbContent> tbContents = tbContentMapper.selectByExample(example);

        jedisSentinel.set(KEY_BIG_AD,FastJsonConvert.convertObjectToJSON(tbContents));
        return tbContents;
    }
}
