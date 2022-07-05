package com.yunst.response.order;

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
public class SignalAgentPayResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -2390380934639479809L;

    private SignalAgentPayVo signedValue;

    @Data
    public static class SignalAgentPayVo {
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
         * 云商通订单号
         */
        private String orderNo;

        /**
         * 商户订单号（支付订单）
         */
        private String bizOrderNo;

        /**
         * 代付去向
         * 1: 到到账户余额
         */
        private Long payWhereabouts;

        /**
         * 扩展参数
         */
        private String extendInfo;
    }
}
