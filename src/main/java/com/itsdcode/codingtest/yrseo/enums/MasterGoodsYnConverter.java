package com.itsdcode.codingtest.yrseo.enums;

public class MasterGoodsYnConverter extends  AbstractBaseEnumConverter<MasterGoodsYn, String> {

    @Override
    protected MasterGoodsYn[] getValueList() {
        return MasterGoodsYn.values();
    }
}