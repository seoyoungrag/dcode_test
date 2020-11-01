package com.itsdcode.codingtest.yrseo.enums;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public abstract class AbstractBaseEnumConverter<X extends Enum<X> & BaseEnumCode<Y>, Y> implements AttributeConverter<X, Y> {

    protected abstract X[] getValueList();

    @Override
    public Y convertToDatabaseColumn(X atr) {
        return atr.getValue();
    }

    @Override
    public X convertToEntityAttribute(Y db) {
        return Arrays.stream(getValueList())
                .filter(e -> e.getValue().equals(db))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", db)));
    }
}
