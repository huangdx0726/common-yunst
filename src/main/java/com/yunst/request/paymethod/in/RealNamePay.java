package com.yunst.request.paymethod.in;

import com.yunst.annotation.EncryptRsa;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 实名付（单笔）
 * @author dudangman
 */
public class RealNamePay extends BasePayMethod {

    private static final String KEY = "REALNAMEPAY";

    public RealNamePay(RealNamePayRequest payMethodRequest) {
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
    public static class RealNamePayRequest extends BasePayMethodRequest {
        /**
         * 银行卡号，RSA 加密。（只支持四要
         */
        @EncryptRsa
        public String bankCardNo;
        /**
         * 支付金额，单位：分
         */
        public Long amount;
    }

}
