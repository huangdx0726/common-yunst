package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum VerificationCodeType {
    /**
     * 绑定手机
     */
    BINDING_MOBILE(9),
    /**
     * 解绑手机
     */
    UN_BINDING_MOBILE(6);
    final Integer code;
    VerificationCodeType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
