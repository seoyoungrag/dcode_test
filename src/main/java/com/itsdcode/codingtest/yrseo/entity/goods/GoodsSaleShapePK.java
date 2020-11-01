package com.itsdcode.codingtest.yrseo.entity.goods;

import java.io.Serializable;
import java.util.Objects;

public class GoodsSaleShapePK implements Serializable {
    private Integer goods;
    private Integer goodsSale;

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }

    public Integer getGoodsSale() {
        return goodsSale;
    }

    public void setGoodsSale(Integer goodsSale) {
        this.goodsSale = goodsSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSaleShapePK that = (GoodsSaleShapePK) o;
        return goods == that.goods &&
                goodsSale == that.goodsSale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods, goodsSale);
    }
}
