package com.yunst.request.paymethod.in;

import cn.hutool.json.JSONObject;
import com.yunst.enums.PayChannel;
import com.yunst.request.BasePayMethod;
import com.yunst.request.ExtUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 支付宝原生手机网站支付
 * @author dudangman
 */
public class AlipayMwebOpen extends BasePayMethod {
    public AlipayMwebOpen(AlipayMwebOpenRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return null;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    public static class AlipayMwebOpenRequest extends BasePayMethodRequest {
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
         * 优惠参数
         */
        private String promo_params;

        /**
         * 业务扩展参数 json 字符串
         */
        private JSONObject extendParams;

        /**
         * 可用支付渠道（最长 100），用户只
         * 能在指定渠道范围内支付，当有多个渠道时用“,”分隔
         */
        private List<PayChannel> enablePayChannels;

        /**
         * 禁用渠道，用户不可用指定渠道支付当有多个渠道时用“,” 分隔; 注:与 enable_pay_channels 互斥
         */
        private List<PayChannel> disablePayChannels;

        /**
         * 用户付款中途退出返回商户网站的地址
         */
        private String quitUrl;

        /**
         * 商户门店编号
         */
        private String storeId;

        /**
         * 指定渠道，目前仅支持传入 pcredit 若由于用户原因渠道不可用，用户可选择是否用其他渠道支付。
         * 注：该参数不可与花呗分期参数同时传入
         */
        private String specifiedChannel;

        /**
         * 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参
         * 数直传场景，格式为 json 格式
         */
        private String businessParams;

        /**
         * 外部买家
         */
        private ExtUserInfo extUserInfo;

    }

}
