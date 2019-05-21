package com.clt.chenshop.service.search.test;

import com.clt.chenshop.common.mapper.search.ItemMapper;
import com.clt.chenshop.common.pojo.search.Item;
import com.clt.chenshop.service.ServiceSearchApplication;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-26 17:51
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ServiceSearchApplication.class)
public class SolrTest {
    /**
     * 依赖注入 SolrClient
     */
    @Autowired
    private SolrClient solrClient;

    @Autowired
    private ItemMapper itemMapper;
//    /**
//     * 添加索引库
//     */
//    @Test
//    public void addDocument() throws IOException, SolrServerException {
//        // 创建一个文档对象
//        SolrInputDocument document = new SolrInputDocument();
//        // 向文档中添加域
//        document.addField("id", "10000");
//        document.addField("item_title", "测试商品");
//        // 把文档添加到索引库
//        solrClient.add(document);
//        // 提交
//        solrClient.commit();
//        // 在代码中指定 Collection，由于已经在 application.yml 中配置了，所以这里不需要
//        // solrClient.commit("ik_core");
//    }
//    /**
//     * 删除索引库
//     */
//    @Test
//    public void delDocument() throws IOException, SolrServerException {
//        solrClient.deleteByQuery("*:*");
//        solrClient.commit();
//    }
    /**
     * 将数据初始化到索引库
     */
    @Test
    public void initDocument() throws IOException, SolrServerException {
        // 查询商品列表
        List<Item> itemList = itemMapper.getItemList();
        System.out.println(itemList.size());
        // 把商品信息写入索引库
        for (Item item : itemList) {
            // 创建一个 SolrInputDocument 对象
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id", item.getId());
            document.setField("item_title", item.getTitle());
            document.setField("item_sell_point", item.getSell_point());
            document.setField("item_price", item.getPrice());
            document.setField("item_image", item.getImage());
            document.setField("item_category_name", item.getCategory_name());
            document.setField("item_desc", item.getItem_desc());
            // 写入索引库
            solrClient.add(document);
            // 提交修改
            solrClient.commit();
        }
    }
}
