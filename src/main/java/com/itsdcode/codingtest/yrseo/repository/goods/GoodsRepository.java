package com.itsdcode.codingtest.yrseo.repository.goods;

import com.itsdcode.codingtest.yrseo.entity.goods.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
