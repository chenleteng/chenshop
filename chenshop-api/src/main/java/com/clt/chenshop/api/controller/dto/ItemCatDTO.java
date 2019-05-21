package com.clt.chenshop.api.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-27 10:57
 **/

@Data
public class ItemCatDTO<T extends ItemCatNode> implements Serializable {
    private List<T> data;
}
