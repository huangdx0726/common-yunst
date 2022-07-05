package com.yunst.request.paymethod.in;

import com.yunst.enums.PayChannel;
import com.yunst.request.BasePayMethod;
import com.yunst.request.ExtUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 支付宝原生APP 支付
 * @author dudangman
 */
public class AlipayAppOpen extends BasePayMethod {
    public AlipayAppOpen(AlipayAppOpenRequest payMethodRequest) {
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
    public static class AlipayAppOpenRequest extends BasePayMethodRequest {
        /**
         * 支付金额，单位：分
         * 注：测试环境：amount 传 9:成功； 传 7：进行中； 传 6：失败
         */
        private Long amount;
        /**
         * 支付宝端 APPID
         * 注：配置两个支付宝 APPID 时，必填
         */
        private String aliAppId;
        /**
         * 可用支付渠道（最长 100），用户只
         * 能在指定渠道范围内支付，当有多个渠道时用“,”分隔
         */
        private List<PayChannel> enablePayChannels;
        /**
         * 支付摘要（最长 100）
         */
        private String paysummary;
        /**
         * 外部买家
         */
        private ExtUserInfo extUserInfo;
    }

}
