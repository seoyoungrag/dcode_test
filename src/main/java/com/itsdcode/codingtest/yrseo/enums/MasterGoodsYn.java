package com.itsdcode.codingtest.yrseo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MasterGoodsYn implements BaseEnumCode<String> {

    YES("Y"),
    NO("N"),
    NULL("") //entity는 not null 이지만 DTO에서 사용하기 위해 NULL을 지정한다.
    ;

    private final String value;
}
