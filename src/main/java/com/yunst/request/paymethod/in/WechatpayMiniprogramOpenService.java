package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.ReceiptFlag;
import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
public class WechatpayMiniprogramOpenService extends BasePayMethod {

    public WechatpayMiniprogramOpenService(WeChatPayMiniProgramOpenServiceRequest payMethodRequest) {
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
    public static class WeChatPayMiniProgramOpenServiceRequest extends BasePayMethodRequest {
        /**
         * 微信子商户号
         */
        private String subMchtId;

        /**
         * 小程序的 APPID
         */
        private String subAppId;

        /**
         * 非贷记卡：no_credit
         * 借、贷记卡：””
         */
        private LimitPay limitPay;

        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 微信小程序支付
         * sub_openid
         */
        private String acct;

        /**
         * 用户下单及调起支付的终端 IP
         */
        private String cusip;

        /**
         * 开发票入口开放标识
         * Y
         */
        private ReceiptFlag receipt;
    }
}
