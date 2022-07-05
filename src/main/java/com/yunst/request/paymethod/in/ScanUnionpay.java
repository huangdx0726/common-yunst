package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝银联扫码支付(正扫)
 * @author dudangman
 */
public class ScanUnionpay extends BasePayMethod {
    public ScanUnionpay(ScanUnionPayRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static abstract class BaseScanUnionPayRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         */
        public Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        public String extendParams;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        public LimitPay limitPay;
    }

    @NoArgsConstructor
    public static class ScanUnionPayRequest extends BaseScanUnionPayRequest {
        @Builder
        public ScanUnionPayRequest(Long amount, String extendParams, LimitPay limitPay) {
            super(amount, extendParams, limitPay);
        }
    }
}
