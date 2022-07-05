package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum ValidateType {
    /**
     * 无验证
     */
    NO(0),
    /**
     * 短信验证码
     * 有效期 3 分钟
     */
    SMS(1)
    ;
    final Integer code;
    ValidateType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
