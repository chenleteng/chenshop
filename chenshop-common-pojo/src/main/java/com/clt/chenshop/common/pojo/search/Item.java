package com.clt.chenshop.common.pojo.search;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-26 15:28
 **/

import lombok.Data;
import java.io.Serializable;

@Data
public class Item implements Serializable {
    private String id;
    private String title;
    private String sell_point;
    private Long price;
    private String image;
    private String category_name;
    private String item_desc;
}

