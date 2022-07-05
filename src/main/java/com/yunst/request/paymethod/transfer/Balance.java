package com.yunst.request.paymethod.transfer;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账户内转账
 * 账户余额
 * @author dudangman
 */
public class Balance extends BasePayMethod {
    public Balance(BalanceRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    public static class BalanceRequest extends BasePayMethodRequest {
        /**
         * 支付金额 单位：分
         */
        private Long amount;

        /**
         * 账户集编号
         */
        private String accountSetNo;
    }
}
