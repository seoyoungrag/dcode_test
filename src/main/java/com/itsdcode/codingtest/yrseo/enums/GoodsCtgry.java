package com.itsdcode.codingtest.yrseo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsCtgry implements BaseEnumCode<String> {

    SHOES("SHO"),
    BAG("BAG"),
    TSHIRT("TSH"),
    PANTS("PAN"),
    HAT("HAT"),
    RING("RIN"),
    NULL("")//entity는 not null 이지만 DTO에서 사용하기 위해 NULL을 지정한다.
    ;

    private final String value;
}