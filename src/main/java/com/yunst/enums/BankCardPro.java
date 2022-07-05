package com.yunst.enums;

import com.yunst.annotation.EnumValue;

/**
 * @author dudangman
 */
public enum BankCardPro {
    /**
     * 个人银行卡
     */
    PERSONAL_ACCOUNT(0),
    /**
     *  企业对公账户
     */
    CORPORATE_ACCOUNT(1)
    ;

    final Integer code;
    BankCardPro(Integer code) {
        this.code = code;
    }

    @EnumValue
    public Integer getCode() {
        return code;
    }
}
