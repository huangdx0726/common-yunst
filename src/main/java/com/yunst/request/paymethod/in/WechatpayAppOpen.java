package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 微信原生 APP 支付
 * @author dudangman
 */
public class WechatpayAppOpen extends BasePayMethod {

    public WechatpayAppOpen(WeChatPayAppOpenRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class WeChatPayAppOpenRequest extends BasePayMethodRequest {

        /**
         * 微信端应用 ID：appid
         */
        private String subAppId;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        private LimitPay limitPay;
    }
}
