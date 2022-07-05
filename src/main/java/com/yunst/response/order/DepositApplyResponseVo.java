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
public class DepositApplyResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -175442802132977643L;

    private DepositApplyVo signedValue;

    @Data
    public static class DepositApplyVo {
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
         * 针对收银宝手机银行 APP 支付才返回，商
         * 户取此字段值作为收银宝 reqsn 订单号上送给收银宝
         */
        private String reqPayInterfaceNo;

        /**
         * 渠道交易流水号
         * 针对收银宝相关支付渠道返回，对应收银
         * 宝交易单号 trxid 字段：
         */
        private String payInterfaceOutTradeNo;

        /**
         * 通道交易类型
         * 仅收银宝-付款码支付方式返回，对应收银宝接口字段 trxcode
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
         * 仅收银宝-付款码支付方式返回， 微信支付的 openid
         * 支付宝平台的 user_id
         */
        private String acct;

        /**
         * 渠道手续费
         * 仅收银宝-付款码支付方式返回
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
         * POS 支付的付款码
         * 6 位数字
         * 收银宝 ORDER_VSPPAY 支付时必传
         */
        private String payCode;

        /**
         * 交易编号
         */
        private String tradeNo;

        /**
         * 微信 APP 支付信息
         */
        private JSONObject weChatAPPInfo;

        /**
         * 扫码支付信息/ JS 支付串信息（微信、支付宝、QQ 钱包）/微信小程序/微信原生 H5 支付串信息/支付宝原生 APP 支付串信息
         */
        private String payInfo;

        /**
         * 交易验证方式
         * 当支付方式为收银宝快捷且需验证短信验证码时才返回，返回值为“1”表示需继续调用【确认支付（后台+短信验证码
         * 确认）】
         */
        private Long validateType;

        /**
         * 扩展信息
         */
        private String extendInfo;

    }
}
