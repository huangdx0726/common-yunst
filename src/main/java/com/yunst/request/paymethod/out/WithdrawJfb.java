package com.yunst.request.paymethod.out;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 金服宝代付
 * @author dudangman
 */
public class WithdrawJfb extends BasePayMethod {
    public WithdrawJfb(WithdrawJfbRequest payMethodRequest) {
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
    public static class WithdrawJfbRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         */
        private Long amount;
        /**
         * 支付行号，12 位数字
         */
        private String unionBank;
        /**
         * 开户行支行名称
         */
        private String bankName;
        /**
         * 开户行所在省
         */
        private String province;
        /**
         * 开户行所在市
         */
        private String city;
    }
}
