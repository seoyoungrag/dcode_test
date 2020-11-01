package com.itsdcode.codingtest.yrseo.dto;

import com.itsdcode.codingtest.yrseo.enums.GoodsSaleShapeCl;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsSaleDTO  implements Serializable {
    private Integer goodsSaleSeq;
    private GoodsSaleShapeCl goodsSaleShapeCl;

}
