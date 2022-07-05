package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum AuthType {
    WECHAT("01"),
    UNION_PAY("02")
    ;

    final String code;
    AuthType(String code) {
        this.code = code;
    }

    @EnumValue
    public String getCode() {
        return code;
    }
}
