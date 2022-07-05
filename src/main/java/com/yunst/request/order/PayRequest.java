package com.yunst.request.order;

import com.yunst.request.BaseOrderRequest;
import com.yunst.request.OrderRequest;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PayRequest extends OrderRequest {
    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 订单申请的商户订单号
     */
    private String bizOrderNo;

    /**
     * 交易编号
     */
    private String tradeNo;

    /**
     * 短信验证码
     */
    private String verificationCode;

    /**
     * ip 地址
     */
    private String consumerIp;
}
