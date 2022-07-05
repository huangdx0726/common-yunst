package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 源托管代收订单付款信息
 * @author dudangman
 */
@Data
@Builder
@AllArgsConstructor
public class CollectPay implements Serializable {

    private static final long serialVersionUID = 8994619743391254895L;

    /**
     * 相关代收交易的“商户订单号”
     */
    private String bizOrderNo;

    /**
     * 非必填，一年前的代收订单必须上送，yyyy-MM-dd 精确到天
     */
    private Date bizOrderCreateDate;

    /**
     * 金额，单位：分
     */
    private Long amount;
}
