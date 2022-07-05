package com.yunst.request.paymethod.in;

import com.yunst.annotation.EncryptRsa;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 通联通协议支付
 * @author dudangman
 */
public class QuickPayTlt extends BasePayMethod {

    private static final String KEY = "QUICKPAY_TLT";
    public QuickPayTlt(QuickPayTltRequest payMethodRequest) {
        super(payMethodRequest);
    }
    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getSimpleName() {
        return null;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuickPayTltRequest extends BasePayMethodRequest {
        /**
         * 银行卡号，RSA 加密。
         */
        @EncryptRsa
        private String bankCardNo;

        /**
         * 有效期，信用卡必填，格式为月年；
         */
        private String validate;

        /**
         * CVV2，信用卡必填。RSA 加密。
         */
        @EncryptRsa
        private String cvv2;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

    }
}
