package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum SourceType {
    /**
     * 移动端
     */
    MOBILE(1),
    /**
     * pc端
     */
    PC(2);
    final Integer code;
    SourceType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
