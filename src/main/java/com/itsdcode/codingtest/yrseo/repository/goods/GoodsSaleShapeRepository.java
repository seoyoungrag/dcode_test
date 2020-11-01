package com.itsdcode.codingtest.yrseo.repository.goods;

import com.itsdcode.codingtest.yrseo.entity.goods.GoodsSaleShape;
import com.itsdcode.codingtest.yrseo.entity.goods.GoodsSaleShapePK;
import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsSaleShapeRepository extends JpaRepository<GoodsSaleShape, GoodsSaleShapePK> {
    List<GoodsSaleShape> findAllByMasterGoodsYn(MasterGoodsYn yn);

    List<GoodsSaleShape> findAllByGoodsSaleGoodsSaleSeq(Integer goodsSaleSeq);
}
