package com.itsdcode.codingtest.yrseo.repository.goods;

import com.itsdcode.codingtest.yrseo.dto.GoodsCondition;
import com.itsdcode.codingtest.yrseo.dto.GoodsDTO;
import com.itsdcode.codingtest.yrseo.entity.goods.GoodsSaleShape;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import com.itsdcode.codingtest.yrseo.repository.Querydsl4RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.itsdcode.codingtest.yrseo.entity.goods.QGoods.goods;
import static com.itsdcode.codingtest.yrseo.entity.goods.QGoodsSale.goodsSale;
import static com.itsdcode.codingtest.yrseo.entity.goods.QGoodsSaleShape.goodsSaleShape;
import static org.springframework.util.StringUtils.isEmpty;

@Repository
public class QGoodsSaleShapeRepository extends Querydsl4RepositorySupport {

    public QGoodsSaleShapeRepository(){
        super(GoodsSaleShape.class);
    }

    public List<GoodsSaleShape> basicSelect() {
        return select(goodsSaleShape).from(goodsSaleShape).fetch();
    }

    public List<GoodsSaleShape> basicSelectFrom(){
        return selectFrom(goodsSaleShape).fetch();
    }

    public List<GoodsDTO> search(GoodsCondition condition){
        JPAQuery<GoodsDTO> query = select(Projections.constructor(GoodsDTO.class,
                goodsSaleShape.goodsSale.goodsSaleSeq,
                goodsSaleShape.goodsSale.goodsSalePrice,
                goodsSaleShape.goodsSale.goodsSaleNm,
                goodsSaleShape.goods.goodsNm,
                goodsSaleShape.goods.goodsCtgry,
                goodsSaleShape.goodsSale.goodsSaleShapeCl,
                goodsSaleShape.masterGoodsYn,
                goodsSaleShape.discntRt
        )).from(goodsSaleShape).leftJoin(goodsSaleShape.goods, goods).where(masterGoodsYnEq(condition.getMasterGoodsYn())).leftJoin(goodsSaleShape.goodsSale, goodsSale).where(goodsSaleSeqEq(condition.getGoodsSaleSeq()));
        return query.fetch();
    }
    private BooleanExpression masterGoodsYnEq(MasterGoodsYn yn){
        return isEmpty(yn) || yn.equals("NULL")? null : goodsSaleShape.masterGoodsYn.eq(yn);
    }

    private BooleanExpression goodsSaleSeqEq(Integer goodsSaleSeq){
        return isEmpty(goodsSaleSeq)? null : goodsSaleShape.goodsSale.goodsSaleSeq.eq(goodsSaleSeq);
    }
}
