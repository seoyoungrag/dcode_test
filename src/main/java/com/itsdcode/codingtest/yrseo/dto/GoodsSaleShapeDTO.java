package com.itsdcode.codingtest.yrseo.dto;

import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsSaleShapeDTO  implements Serializable {

    private GoodsDTO goods;
    private GoodsSaleDTO goodsSale;
    private MasterGoodsYn masterGoodsYn;
    private Integer discntRt;
}
