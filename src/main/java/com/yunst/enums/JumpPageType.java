package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum JumpPageType {
    H5(1),
    APPLET(2)
    ;
    final Integer code;
    JumpPageType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
