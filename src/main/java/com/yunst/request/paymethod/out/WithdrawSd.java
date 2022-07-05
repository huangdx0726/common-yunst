package com.yunst.request.paymethod.out;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 山东代付
 * @author dudangman
 */
public class WithdrawSd extends BasePayMethod {
    public WithdrawSd(WithdrawSdRequest payMethodRequest) {
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
    public static class WithdrawSdRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 支付行号
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

        /**
         * 附言，小于 20 个字段
         */
        private String paysummary;
    }
}
