package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * 企业认证类型
 * @author dudangman
 */
public enum CompanyAuthType {
    /**
     * 三证
     */
    THREE(1),
    /**
     * 一证
     */
    ONE(2)
    ;
    final Integer code;
    CompanyAuthType(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
