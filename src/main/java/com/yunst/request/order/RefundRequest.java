package com.yunst.request.order;

import com.yunst.enums.RefundType;
import com.yunst.request.OrderRequest;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RefundRequest extends OrderRequest {
    /**
     * 商户订单号（支付订单）
     */
    private String bizOrderNo;

    /**
     * 商户原订单号
     * 需要退款的原交易订单号
     */
    private String oriBizOrderNo;

    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 退款方式
     * 默认D1
     */
    private RefundType refundType;

    /**
     * 收款人的退款金额
     */
    private Object refundList;

    /**
     * 后台通知地址
     */
    private String backUrl;

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
     * 扩展信息
     */
    private String extendInfo;
}
