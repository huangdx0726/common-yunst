package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum UserState {
    /**
     * 有效
     */
    VALID(1),
    /**
     * 审核失败
     */
    AUDIT_FAILED(3),
    /**
     * 已锁
     */
    LOCKED(5),
    /**
     * 待审核
     */
    WAITING_AUDIT(7)
    ;

    final Integer code;
    UserState(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
