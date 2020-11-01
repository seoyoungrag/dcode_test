package com.itsdcode.codingtest.yrseo.dto;

import com.itsdcode.codingtest.yrseo.enums.GoodsCtgry;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeCl;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsDTOForDCODE implements Serializable {

    private Integer goodsSaleSeq;
    private Integer goodsPrice;
    private String goodsNm;
    private String goodsSaleNm;
    private GoodsCtgry goodsCtgry;
    private GoodsSaleShapeCl goodsSaleShapeCl;
    private MasterGoodsYn masterGoodsYn;
    private Integer discntRt;

    public GoodsDTOForDCODE() {
    }

    public GoodsDTOForDCODE(Integer goodsSaleSeq, Integer goodsPrice, String goodsSaleNm, String goodsNm, GoodsCtgry goodsCtgry, GoodsSaleShapeCl goodsSaleShapeCl, MasterGoodsYn masterGoodsYn, Integer discntRt) {
        this.goodsSaleSeq = goodsSaleSeq;
        this.goodsPrice = goodsPrice;
        this.goodsSaleNm = goodsSaleNm;
        this.goodsNm = goodsNm;
        this.goodsCtgry = goodsCtgry;
        this.goodsSaleShapeCl = goodsSaleShapeCl;
        this.masterGoodsYn = masterGoodsYn;
        this.discntRt = discntRt;
    }
}
