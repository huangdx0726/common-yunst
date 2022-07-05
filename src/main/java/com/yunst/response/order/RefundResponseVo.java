package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class RefundResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 3935530984542098276L;

    private RefundVo signedValue;

    @Data
    public static class RefundVo {
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
         * 云商通订单编号
         */
        private String orderNo;

        /**
         * 商户订单号（支付订单）
         */
        private String bizOrderNo;

        /**
         * 本次退款总金额
         */
        private Long amount;

        /**
         * 代金券退款金额
         */
        private Long couponAmount;

        /**
         * 手续费退款金额
         */
        private Long feeAmount;

        /**
         * 终端交易卡号
         */
        private String termAcctNo;

        /**
         * 终端交易卡号发卡机构
         */
        private String termBankName;

        /**
         * 收单机构
         */
        private String aptCode;

        /**
         * 终端授权码
         */
        private String termAuthCode;

        /**
         * 扩展信息
         */
        private String extendInfo;
    }
}
