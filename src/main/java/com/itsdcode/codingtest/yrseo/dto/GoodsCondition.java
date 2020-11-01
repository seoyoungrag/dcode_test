package com.itsdcode.codingtest.yrseo.dto;

import com.itsdcode.codingtest.yrseo.enums.MasterGoodsYn;
import lombok.Data;

@Data
public class GoodsCondition {
    private Integer goodsSaleSeq;
    private MasterGoodsYn masterGoodsYn;
}
