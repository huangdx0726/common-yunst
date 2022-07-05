package com.yunst.request.paymethod.in;

import com.yunst.annotation.EncryptRsa;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝快捷支付
 * @author dudangman
 */
public class QuickpayVsp extends BasePayMethod {

    public QuickpayVsp(QuickPayVspRequest payMethodRequest) {
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
    @NoArgsConstructor
    public static class QuickPayVspRequest extends BasePayMethodRequest {
        /**
         * 银行卡号，RSA 加密。
         */
        @EncryptRsa
        private String bankCardNo;

        /**
         * 支付金额，单位：分
         */
        private Long amount;
    }
}
