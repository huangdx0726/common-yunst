package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum OperationType {
    SET("set"),
    QUERY("query")
    ;
    final String type;
    OperationType(String type) {
        this.type = type;
    }

    @EnumValue
    public String getType() {
        return type;
    }
}
