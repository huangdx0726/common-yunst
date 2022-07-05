package com.yunst.response.order;

import lombok.Data;

/**
 * @author dudangman
 */
@Data
public class AccountDetail {

    /**
     * 收支明细流水号
     */
    private String tradeNo;

    /**
     * 账户集名称
     */
    private String accountSetName;

    /**
     * 变更时间
     */
    private String changeTime;

    /**
     * 现有金额
     */
    private Long curAmount;

    /**
     * 原始金额
     */
    private Long oriAmount;

    /**
     * 变更金额
     */
    private Long chgAmount;

    /**
     * 现有冻结金额
     */
    private Long curFreezenAmount;

    /**
     * 商户订单号（支付订单）
     */
    private String bizOrderNo;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 交易子类型
     */
    private String type;

    /**
     * 分账备注
     */
    private String remark;

    /**
     * 扩展参数
     */
    private String extendInfo;
}
