package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum LimitPay {
    NO_CREDIT("no_credit"),
    CREDIT(""),
    TO_CREDIT("to_credit")
    ;

    final String code;
    LimitPay(String code) {
        this.code = code;
    }

    @EnumValue
    public String getCode() {
        return code;
    }
}
