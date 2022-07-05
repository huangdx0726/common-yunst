package com.yunst.enums;

/**
 * 支付渠道
 * @author dudangman
 */
public enum PayChannel {
    /**
     * 余额
     */
    balance,
    /**
     * 余额宝
     */
    moneyFund,
    /**
     * 网银
     */
    bankPay,
    /**
     * 借记卡快捷
     */
    debitCardExpress,

    /**
     * 信用卡快捷
     */
    creditCardExpress,

    /**
     * 信用卡卡通
     */
    creditCardCartoon,

    /**
     * 信用卡
     */
    creditCard,
    /**
     * 卡通
     */
    cartoon,

    /**
     * 花呗
     */
    pcredit,
    /**
     * 花呗分期
     */
    pcreditpayInstallment,

    /**
     * 信用支付类型（包含 信用卡卡通，信用卡快捷,花呗，
     *     花呗分期）
     */
    credit_group,
    /**
     * 红包
     */
    coupon,
    /**
     * 积分
     */
    point,
    /**
     * 优惠（包含实时优惠+商户优惠）
     */
    promotion,
    /**
     * 营销卷
     */
    voucher,
    /**
     * 商户优惠
     */
    mdiscount,
    /**
     * 亲密付
     */
    honeyPay,
    /**
     * 商户预存卡
     */
    mcard,
    /**
     * 个人预存卡
     */
    pcard
 }
