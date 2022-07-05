package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ConsumeApplyResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -6317616069497314513L;

    private ConsumeApplyVo signedValue;

    @Data
    public static class ConsumeApplyVo {
        /**
         * 仅交易验证方式为“0”时返回成功：success
         * 进行中：pending 失败：fail
         * 订单成功时会发订单结果通知商户。
         * 其中收银宝 POS/当面付查询模式、手机银行 APP、微信支付宝等须用户在终端确认支付的，不返回此字段
         */
        private String payStatus;

        /**
         * 支付失败信息
         * 仅交易验证方式为“0”时返回
         * 只有 payStatus 为 fail 时有效
         */
        private String payFailMessage;

        /**
         * 商户系统用户标识
         */
        private String bizUserId;

        /**
         * 云商通订单号
         */
        private String orderNo;

        /**
         * 商户订单号（支付订单）
         */
        private String bizOrderNo;

        /**
         * 请求渠道流水号
         */
        private String reqPayInterfaceNo;

        /**
         * 渠道交易流水号
         */
        private String payInterfaceOutTradeNo;

        /**
         * 交易编号
         */
        private String tradeNo;

        /**
         * 订单 POS 支付的付款码
         */
        private String payCode;

        /**
         * 扩展参数
         */
        private String extendInfo;

        /**
         * 微信 APP 支付信息
         */
        private String weChatAPPInfo;

        /**
         * 扫码支付信息/ JS 支付串信息（微信、支付宝、QQ 钱包）/微信小程序/ 微信原生 H5 支付串信息
         * /支付宝原生 APP 支付串信息
         */
        private String payInfo;

        /**
         * 通道交易类型
         */
        private String payInterfacetrxcod;

        /**
         * 支付人帐号
         */
        private String acct;

        /**
         * 渠道手续费
         */
        private String channelFee;

        /**
         * 收银宝渠道信息
         */
        private String chnldata;

        /**
         * 渠道交易完成时间
         */
        private String channelPaytime;

        /**
         * 渠道商户号
         */
        private String cusid;

        /**
         * 交易验证方式
         * 当支付方式为收银宝快捷且需验证短信验证码时才返回，
         * 返回值为“1”表示需继续调用【确认支付（后台+短信验证码确认）】
         */
        private String validateType;
    }
}
