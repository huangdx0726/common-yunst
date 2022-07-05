package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.enums.ReceiptFlag;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 微信原生正扫支付
 * @author dudangman
 */
public class WechatpayScanOpen extends BasePayMethod {
    public WechatpayScanOpen(WeChatPayScanOpen payMethodRequest) {
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
    public static class WeChatPayScanOpen extends BasePayMethodRequest {
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
         * {"store_info":{"id": "门店
         * ID","name": "名称","area_code":
         * "编码","address": "地址" }}
         */
        private String sceneInfo;

        /**
         * 开发票入口开放标识
         */
        private ReceiptFlag receipt;

    }
}
