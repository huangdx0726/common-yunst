package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum WithdrawType {
    /**
     * D+0 到账
     */
    D0("D0"),
    /**
     * D+1 到账
     */
    D1("D1"),
    /**
     * T+1 到账，仅工作日代付
     */
    T1customized("T1customized"),
    /**
     * D+0 到账，根据平台资金头寸付款
     */
    D0customized("D0customized");

    final String type;
    WithdrawType(String type) {
        this.type = type;
    }

    @EnumValue
    public String getType() {
        return type;
    }
}
