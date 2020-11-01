package com.itsdcode.codingtest.yrseo.entity.goods;

import com.itsdcode.codingtest.yrseo.entity.common.CommonDateEntity;
import com.itsdcode.codingtest.yrseo.enums.GoodsCtgry;
import com.itsdcode.codingtest.yrseo.enums.GoodsCtgryConverter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "GOODS")
@DynamicInsert
public class Goods extends CommonDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_SEQ", length = 11, nullable = false)
    private Integer goodsSeq;

    @Column(name = "GOODS_PRICE", length = 11, nullable = false)
    private Integer goodsPrice;

    @Column(name = "GOODS_NM", length = 200, nullable = false)
    private String goodsNm;

    @Column(name = "GOODS_CTGRY", length = 4, nullable = false)
    @Convert(converter = GoodsCtgryConverter.class)
    private GoodsCtgry goodsCtgry;

    @OneToMany(mappedBy = "goods")
    private List<GoodsSaleShape> goodsSaleShapes = new ArrayList<GoodsSaleShape>();

    public Goods() {
    }

    public Goods(Integer goodsPrice, String goodsNm, GoodsCtgry goodsCtgry) {
        this.goodsPrice = goodsPrice;
        this.goodsNm = goodsNm;
        this.goodsCtgry = goodsCtgry;
    }

    public List<GoodsSaleShape> getGoodsSaleShapes(){
        return this.goodsSaleShapes;
    }
    public Integer getGoodsSeq() {
        return goodsSeq;
    }

    public void setGoodsSeq(Integer goodsSeq) {
        this.goodsSeq = goodsSeq;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsNm() {
        return goodsNm;
    }

    public void setGoodsNm(String goodsNm) {
        this.goodsNm = goodsNm;
    }

    public GoodsCtgry getGoodsCtgry() {
        return goodsCtgry;
    }

    public void setGoodsCtgry(GoodsCtgry goodsCtgry) {
        this.goodsCtgry = goodsCtgry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return goodsSeq == goods.goodsSeq &&
                goodsPrice == goods.goodsPrice &&
                Objects.equals(goodsNm, goods.goodsNm) &&
                Objects.equals(goodsCtgry, goods.goodsCtgry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsSeq, goodsPrice, goodsNm, goodsCtgry);
    }
}
