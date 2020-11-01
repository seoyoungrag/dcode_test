package com.itsdcode.codingtest.yrseo.enums;

public class GoodsCtgryConverter extends  AbstractBaseEnumConverter<GoodsCtgry, String> {

    @Override
    protected GoodsCtgry[] getValueList() {
        return GoodsCtgry.values();
    }
}