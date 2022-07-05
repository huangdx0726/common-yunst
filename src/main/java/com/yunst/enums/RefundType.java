package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum RefundType {
    D1("D1"),
    D0("D0")
    ;
    final String type;
    RefundType (String type) {
        this.type = type;
    }

    @EnumValue
    public String getType() {
        return type;
    }
}
