package com.clt.chenshop.api.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-11-27 10:58
 **/

@Data
public class ItemCatNode implements Serializable {
    @JsonProperty("u")
    private String url;

    @JsonProperty("n")
    private  String name;

    @JsonProperty("i")
    private List<?> item;

}
