package com.yunst.response.order;

import lombok.Data;

/**
 * 订单结果通知
 * todo backUrl 接受参数
 * @author dudangman
 */
@Data
public class PayResultNotification {
    /**
     * 分配的系统编号
     */
    private String sysid;
    /**
     * 签名
     */
    private String sign;
    /**
     * 请求时间戳
     */
    private String timestamp;

    /**
     * 接口版本(现为 2.0)
     */
    private String v = "2.0";

    private PayResultResponse rps;

    @Data
    public static class PayResultResponse {
        /**
         * 服务名称
         */
        private String service;
        /**
         * 方法名称
         */
        private String method;
        /**
         * 返回结果
         */
        private PayResultReturnValue returnValue;

        /**
         * 订单是否成功
         * “OK” 标 识 支 付 成 功 ；
         * “pending”表示进行中（中间状态）
         * “error”表示支付失败；
         */
        private String status;
        /**
         * 错误代码
         */
        private String errorCode;
        /**
         * 错误信息
         */
        private String message;
    }

    @Data
    public static class PayResultReturnValue {
        /**
         * 云商通订单号
         */
        private String orderNo;

        /**
         * 商户订单号（ 支付订单）
         */
        private String bizOrderNo;

        /**
         * 原云商通订单号
         */
        private String oriOrderNo;

        /**
         * 原商户订单号
         */
        private String oriBizOrderNo;

        /**
         * 订单金额
         */
        private Long amount;

        /**
         * 订单支付完成时间
         */
        private String payDatetime;

        /**
         * 商户系统用户标识
         */
        private String buyerBizUserId;

        /**
         * 退款去向
         * 1：到账户余额
         * 2：到原支付账户银行卡/微信/支付宝等
         */
        private Long refundWhereabouts;

        /**
         * 代付去向
         */
        private Long payWhereabouts;

        /**
         * 支付人帐号
         */
        private String acct;

        /**
         * 借贷标志
         *
         * 刷卡消费交易必传
         * 00-借记卡
         * 01-存折
         * 02-信用卡
         * 03-准贷记卡
         * 04-预付费卡
         * 05-境外卡
         * 99-其他
         */
        private String accttype;

        /**
         * 终端号
         */
        private String termno;

        /**
         * 渠道商户号
         */
        private String cusid;

        /**
         * 通道交易流水号
         */
        private String payInterfaceOutTradeNo;

        /**
         * 通道交易流水号
         */
        private String termrefnum;

        /**
         * 渠道手续费
         */
        private String channelFee;

        /**
         * 渠道交易完成时间
         */
        private String channelPaytime;

        /**
         * 通道交易类型
         */
        private String payInterfacetrxcode;

        /**
         * 收银宝终端流水
         */
        private String traceno;

        /**
         * 收银宝渠道信息
         */
        private String chnldata;

        /**
         * 扩展参数
         */
        private String extendInfo;
    }
}
