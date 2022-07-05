package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum TradeType {
    /**
     * 充值
     */
    DEPOSIT(1),
    /**
     * 转账
     */
    TRANSFER(2),
    /**
     * 提现
     */
    WITHDRAWAL(3),
    /**
     * 退款
     */
    REFUND(4),
    /**
     * 应收账款确认
     */
    RECEIVABLE(5),
    /**
     * 收银宝退款资金调拨
     */
    ALLOCATION_SYB(9),
    /**
     * 应收账款手续费确认
     */
    CONFIRMATION_RECEIVABLE(10);

    final Integer code;
    TradeType (Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
