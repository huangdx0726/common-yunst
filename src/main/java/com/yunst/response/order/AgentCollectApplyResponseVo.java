package com.yunst.response.order;

import cn.hutool.json.JSONObject;
import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class AgentCollectApplyResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 982234518478893952L;

    private AgentCollectApplyVo signedValue;

    @Data
    public static class AgentCollectApplyVo {

        /**
         * 仅交易验证方式为“0”时返回
         * 成 功 ：success
         * 进行中：pending
         * 失败：fail
         */
        private String payStatus;

        /**
         * 支付失败信息
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
         * 渠道交易流水号
         */
        private String payInterfaceOutTradeNo;

        /**
         * 交易编号
         */
        private String tradeNo;

        /**
         * POS 支付的付款码
         */
        private String payCode;

        /**
         * 扩展参数
         */
        private String extendInfo;

        /**
         * 微信 APP 支付信息
         */
        private JSONObject weChatAPPInfo;

        /**
         * 扫码支付信息/ JS 支付串信息（微信、支付宝、QQ 钱包）/微信小程序/微信
         * 原生 H5 支付串信息/支付宝原生 APP 支付串信息
         */
        private String payInfo;

        /**
         * 通道交易类型
         *
         * 对应收银宝接口字段trxcode
         * VSP501 微信支付
         * VSP502 微信支付撤销
         * VSP503 微信支付退款
         * VSP505 手机 QQ 支付
         * VSP506 手机 QQ 支付撤销
         * VSP507 手机 QQ 支付退款
         * VSP511 支付宝支付
         * VSP512 支付宝支付撤销
         * VSP513 支付宝支付退款
         * VSP551 银联扫码支付
         * VSP552 银联扫码撤销
         * VSP553 银联扫码退货
         */
        private String payInterfacetrxcode;

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
         */
        private String validateType;
    }
}
