package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.ReceiptFlag;
import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 微信原生JS 支付
 * @author dudangman
 */
public class WechatpayPublicOpen extends BasePayMethod {
    public WechatpayPublicOpen(WechatPayPublicOpenRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return null;
    }

    @EqualsAndHashCode(callSuper = true)
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class WechatPayPublicOpenRequest extends BasePayMethodRequest {
        /**
         * 微信端应用 ID：appid
         */
        private String wxAppId;

        /**
         * 微信商户号：mchtId
         */
        private String wxMchtId;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””，需要传空字符串，不能不传
         */
        private LimitPay limitPay;

        /**
         * 用户下单及调起支付的终端 IP
         * 注：最大长度 16
         */
        private String cusip;

        /**
         * 微信用户标识 openid——微信分配
         */
        private String acct;

        /**
         * 开发票入口开放标识Y
         */
        private ReceiptFlag receipt;
    }
}
