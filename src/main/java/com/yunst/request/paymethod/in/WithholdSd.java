package com.yunst.request.paymethod.in;

import com.yunst.annotation.EncryptRsa;
import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 山东代收
 * @author dudangman
 */
public class WithholdSd extends BasePayMethod {
    public WithholdSd(WithHoldSdRequest payMethodRequest) {
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
    public static class WithHoldSdRequest extends BasePayMethodRequest {
        /**
         * 银行账号（个人及企业），RSA 加密
         */
        @EncryptRsa
        private String bankCardNo;

        /**
         * 开户行所在省
         */
        private String province;

        /**
         * 开户行所在市
         */
        private String city;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 附言，小于 20 个字段
         */
        private String paysummary;
    }
}
