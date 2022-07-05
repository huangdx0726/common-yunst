package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum PayType {
    B2C("B2C"),
    B2B("B2B"),
    B2C_AND_B2B("B2C,B2B")
    ;
    final String type;
    PayType(String type) {
        this.type = type;
    }

    @EnumValue
    public String getType() {
        return type;
    }
}
