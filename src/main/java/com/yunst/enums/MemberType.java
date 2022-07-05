package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum MemberType {
    /**
     * 企业会员
     */
    ENTERPRISE_MEMBER(2),
    /**
     * 个人会员
     */
    PERSONAL_MEMBER(3);

    final Integer code;
    MemberType(Integer code){
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
