package com.itsdcode.codingtest.yrseo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsSaleShapeCl implements BaseEnumCode<String> {

    ONE_PLUS_ONE("OPO"),//원플러스원
    BUNDLE("BUN"),//묶음상품
    OPTION("OPT"),//옵션상품
    ONE("ONE")//단품상품
    ;

    private final String value;
}
