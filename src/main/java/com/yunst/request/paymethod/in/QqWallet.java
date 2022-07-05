package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝QQ 钱包JS 支付
 * @author dudangman
 */
public class QqWallet extends BasePayMethod {
    public QqWallet(QqWalletRequest payMethodRequest) {
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
    public static class QqWalletRequest extends BasePayMethodRequest {
        /**
         * 支付金额
         * 单位：分
         */
        private Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        private String extendParams;
    }
}
