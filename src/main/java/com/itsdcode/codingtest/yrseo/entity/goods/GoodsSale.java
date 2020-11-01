package com.itsdcode.codingtest.yrseo.entity.goods;

import com.itsdcode.codingtest.yrseo.entity.common.CommonDateEntity;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeCl;
import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeClConverter;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "GOODS_SALE")
@DynamicInsert
public class GoodsSale extends CommonDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_SALE_SEQ", length = 11, nullable = false)
    private Integer goodsSaleSeq;

    @Column(name = "GOODS_SALE_SHAPE_CL", length = 4, nullable = false)
    @Convert(converter = GoodsSaleShapeClConverter.class)
    private GoodsSaleShapeCl goodsSaleShapeCl;

    @Column(name = "GOODS_SALE_NM", length = 200, nullable = false)
    private String goodsSaleNm;

    @Column(name = "GOODS_SALE_PRICE", length = 11, nullable = false)
    private Integer goodsSalePrice;

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

    public Integer getGoodsSalePrice() {
        return goodsSalePrice;
    }

    public void setGoodsSalePrice(Integer goodsSalePrice) {
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

    public void makeGoodsSaleNm() {
        StringBuilder sb = new StringBuilder(this.goodsSaleShapes.stream().map(GoodsSaleShape::getGoods).map(Goods::getGoodsNm).collect(Collectors.joining("+")));
        if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.BUNDLE)){
            sb.append("(").append("묶음상품").append(")");
        }else if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.ONE_PLUS_ONE)){
            sb.append("(").append("1+1").append(")");
        }else if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.OPTION)){
            sb.append("(").append("옵션상품").append(")");
        }
        this.goodsSaleNm = sb.toString();
    }

    public void makePrice() {
        Integer goodsSalePrice = 0;
        for(GoodsSaleShape gs : this.goodsSaleShapes){
            if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.BUNDLE)){
                goodsSalePrice += (gs.getGoods().getGoodsPrice()-(gs.getGoods().getGoodsPrice()*(gs.getDiscntRt()/100)));
            }else if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.ONE_PLUS_ONE)){
                if(gs.getMasterGoodsYn().equals(MasterGoodsYn.YES)) {
                    goodsSalePrice = gs.getGoods().getGoodsPrice()-(gs.getGoods().getGoodsPrice()*(gs.getDiscntRt()/100));
                }
            }else if(this.goodsSaleShapeCl.equals(GoodsSaleShapeCl.OPTION)){
                if(gs.getMasterGoodsYn().equals(MasterGoodsYn.YES)) {
                    goodsSalePrice = gs.getGoods().getGoodsPrice()-(gs.getGoods().getGoodsPrice()*(gs.getDiscntRt()/100));
                }
            }else{
                if(gs.getMasterGoodsYn().equals(MasterGoodsYn.YES)) {
                    goodsSalePrice = gs.getGoods().getGoodsPrice()-(gs.getGoods().getGoodsPrice()*(gs.getDiscntRt()/100));
                }
            }
        }
        this.goodsSalePrice = goodsSalePrice;
    }
}
