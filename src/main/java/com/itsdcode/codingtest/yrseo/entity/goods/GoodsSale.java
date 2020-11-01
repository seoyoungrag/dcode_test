package com.itsdcode.codingtest.yrseo.entity.goods;

import com.itsdcode.codingtest.yrseo.entity.common.CommonDateEntity;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeCl;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeClConverter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "GOODS_SALE")
@DynamicInsert
public class GoodsSale extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_SALE_SEQ")
    private Integer goodsSaleSeq;

    @Column(name = "GOODS_SALE_SHAPE_CL")
    @Convert(converter = GoodsSaleShapeClConverter.class)
    private GoodsSaleShapeCl goodsSaleShapeCl;

    @Column(name = "GOODS_SALE_NM")
    private String goodsSaleNm;

    @Column(name = "GOODS_SALE_PRICE")
    private String goodsSalePrice;

    @OneToMany(mappedBy = "goods")
    private List<GoodsSaleShape> goodsSaleShapes = new ArrayList<GoodsSaleShape>();

    public GoodsSale() {
    }

    public GoodsSale(GoodsSaleShapeCl goodsSaleShapeCl) {
        this.goodsSaleShapeCl = goodsSaleShapeCl;
    }

    public List<GoodsSaleShape> getGoodsSaleShapes(){
        return this.goodsSaleShapes;
    }

    public String getGoodsSaleNm() {
        return goodsSaleNm;
    }

    public void setGoodsSaleNm(String goodsSaleNm) {
        this.goodsSaleNm = goodsSaleNm;
    }

    public String getGoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setGoodsSalePrice(String goodsSalePrice) {
        this.goodsSalePrice = goodsSalePrice;
    }

    public Integer getGoodsSaleSeq() {
        return goodsSaleSeq;
    }

    public void setGoodsSaleSeq(Integer goodsSaleSeq) {
        this.goodsSaleSeq = goodsSaleSeq;
    }

    public GoodsSaleShapeCl getGoodsSaleShapeCl() {
        return goodsSaleShapeCl;
    }

    public void setGoodsSaleShapeCl(GoodsSaleShapeCl goodsSaleShapeCl) {
        this.goodsSaleShapeCl = goodsSaleShapeCl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSale goodsSale = (GoodsSale) o;
        return goodsSaleSeq == goodsSale.goodsSaleSeq &&
                Objects.equals(goodsSaleShapeCl, goodsSale.goodsSaleShapeCl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsSaleSeq, goodsSaleShapeCl);
    }
}
