package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.ReceiptFlag;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 微信原生小程序支付
 * @author dudangman
 */
public class WeChatPayMiniProgramOpen extends BasePayMethod {

    private static final String KEY = "WECHATPAY_MINIPROGRAM_OPEN";

    public WeChatPayMiniProgramOpen(WeChatPayMiniProgramOpenRequest payMethodRequest) {
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
    public static class WeChatPayMiniProgramOpenRequest extends BasePayMethodRequest {
        /**
         * 微信端应用 ID：appid
         */
        private String wxAppId;

        /**
         * 微信商户号：mchtId
         */
        private String wxMchtId;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        private LimitPay limitPay;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * （支付平台用户标识）
         * 微信小程序支付 openid——微信分配
         */
        private String acct;

        /**
         * 用户下单及调起支付的终端 IP
         */
        private String cusip;

        /**
         * 开发票入口开放标识 Y，
         * 传入Y 时，支付成功消息和支付详情页将出现开票入口。
         * 需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效
         */
        private ReceiptFlag receipt;
    }
}
