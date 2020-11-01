package com.itsdcode.codingtest.yrseo.dto;

import com.itsdcode.codingtest.yrseo.enums.GoodsCtgry;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsDTO implements Serializable {

    private Integer goodsSeq;
    private Integer goodsPrice;
    private String goodsNm;
    private GoodsCtgry goodsCtgry;

}
