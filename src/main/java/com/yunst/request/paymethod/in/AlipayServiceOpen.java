package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import com.yunst.request.ExtUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 支付宝原生JS 支付
 * @author dudangman
 */
public class AlipayServiceOpen extends BasePayMethod {
    public AlipayServiceOpen(AlipayServiceOpenRequest payMethodRequest) {
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
    public static class AlipayServiceOpenRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         */
        private Long amount;

        /**
         * 支付宝端 APPID
         * 注：配置两个支付宝 APPID 时，必填
         */
        private String aliAppId;

        /**
         * 支付宝 JS 支付 user_id——支付宝分配
         */
        private String acct;

        /**
         * 外部买家
         */
        private ExtUserInfo extUserInfo;
    }
}
