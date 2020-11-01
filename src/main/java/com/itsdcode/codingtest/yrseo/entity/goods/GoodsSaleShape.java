package com.itsdcode.codingtest.yrseo.entity.goods;

import com.itsdcode.codingtest.yrseo.entity.common.CommonDateEntity;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYnConverter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GOODS_SALE_SHAPE")
@IdClass(GoodsSaleShapePK.class)
public class GoodsSaleShape extends CommonDateEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS_SEQ", referencedColumnName = "GOODS_SEQ", nullable = false)
    private Goods goods;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS_SALE_SEQ", referencedColumnName = "GOODS_SALE_SEQ", nullable = false)
    private GoodsSale goodsSale;

    @Column(name = "MASTER_GOODS_YN", length = 1, nullable = false)
    @Convert(converter = MasterGoodsYnConverter.class)
    private MasterGoodsYn masterGoodsYn;

    @Column(name = "DISCNT_RT", length = 3, nullable = false)
    private Integer discntRt;

    public GoodsSaleShape() {
    }

    public GoodsSaleShape(Goods goods, GoodsSale goodsSale, MasterGoodsYn masterGoodsYn, Integer discntRt) {
        this.goods = goods;
        this.goodsSale = goodsSale;
        this.masterGoodsYn = masterGoodsYn;
        this.discntRt = discntRt;
        if(goods != null){
            changeGoods(goods);
        }
        if(goodsSale != null){
            changeGoodsSale(goodsSale);
        }
    }

    @PrePersist
    public void prePersist() {
        this.discntRt = this.discntRt == null ? 0 : this.discntRt;
    }

    public MasterGoodsYn getMasterGoodsYn() {
        return masterGoodsYn;
    }

    public void setMasterGoodsYn(MasterGoodsYn masterGoodsYn) {
        this.masterGoodsYn = masterGoodsYn;
    }

    public Integer getDiscntRt() {
        return discntRt;
    }

    public void setDiscntRt(Integer discntRt) {
        this.discntRt = discntRt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSaleShape that = (GoodsSaleShape) o;
        return goods == that.goods &&
                goodsSale == that.goodsSale &&
                discntRt == that.discntRt &&
                Objects.equals(masterGoodsYn, that.masterGoodsYn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goods, goodsSale, masterGoodsYn, discntRt);
    }

    public Goods getGoods() {
        return goods;
    }

    public GoodsSale getGoodsSale() {
        return goodsSale;
    }

    public void changeGoods(Goods goods){
        if(this.goods != null) {	// this.goods null이 아니면 이 goodsSaleShape객체는 goods가 있음을 의미
            this.goods.getGoodsSaleShapes().remove(this);		// 해당 goodsSaleShape의 goods를 삭제
        }
        this.goods = goods;
        goods.getGoodsSaleShapes().add(this);
    }
    public void changeGoodsSale(GoodsSale goodsSale){
        if(this.goodsSale != null) {	// this.setGoodsSale null이 아니면 이 goodsSaleShape객체는 setGoodsSale가 있음을 의미
            this.goodsSale.getGoodsSaleShapes().remove(this);		// 해당 goodsSaleShape의 setGoodsSale를 삭제
        }
        this.goodsSale = goodsSale;
        goodsSale.getGoodsSaleShapes().add(this);
        goodsSale.makeGoodsSaleNm();
        goodsSale.makePrice();
    }


}
