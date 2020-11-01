package com.itsdcode.codingtest.yrseo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsSaleShapeCl implements BaseEnumCode<String> {

    ONE_PLUS_ONE("OPO"),
    BUNDLE("BUN"),
    OPTION("OPT"),
    NULL("")//entity는 not null 이지만 DTO에서 사용하기 위해 NULL을 지정한다.
    ;

    private final String value;
}
