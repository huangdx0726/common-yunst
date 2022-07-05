package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseOrderRequest extends OrderRequest {

    /**
     * 商户订单号（支付订单）
     */
    public String bizOrderNo;

    /**
     * 订单金额
     */
    public Long amount;

    /**
     * 手续费
     */
    public Long fee;

    /**
     * 后台通知地址
     */
    private String backUrl;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 扩展信息
     */
    private String extendInfo;
}
