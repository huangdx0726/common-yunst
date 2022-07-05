package com.yunst.request.order;

import com.yunst.enums.BankCardPro;
import com.yunst.enums.SourceType;
import com.yunst.enums.ValidateType;
import com.yunst.enums.WithdrawType;
import com.yunst.request.BaseOrderRequest;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class WithdrawApplyRequest extends BaseOrderRequest {
    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 账户集编号
     */
    private String accountSetNo;

    /**
     * 交易验证方式
     */
    private ValidateType validateType;

    /**
     * 订单过期时间
     */
    private String orderExpireDatetime;

    /**
     * 支付方式
     * 有些支出组合方式
     */
    private BasePayMethod payMethod;

    /**
     * 银行卡号/账号
     */
    private String bankCardNo;

    /**
     * 银行卡/账户属性
     */
    private BankCardPro bankCardPro;

    /**
     * 提现方式
     * 默认D0
     */
    private WithdrawType withdrawType = WithdrawType.D0;
    /**
     * 行业代码
     */
    private String industryCode;

    /**
     * 行业名称
     */
    private String industryName;

    /**
     * 访问终端类型
     */
    private SourceType source;

    @Builder
    public WithdrawApplyRequest(String bizOrderNo, Long amount, Long fee, String backUrl, String summary, String extendInfo, String bizUserId, String accountSetNo, ValidateType validateType, String orderExpireDatetime, BasePayMethod payMethod, String bankCardNo, BankCardPro bankCardPro, WithdrawType withdrawType, String industryCode, String industryName, SourceType source) {
        super(bizOrderNo, amount, fee, backUrl, summary, extendInfo);
        this.bizUserId = bizUserId;
        this.accountSetNo = accountSetNo;
        this.validateType = validateType;
        this.orderExpireDatetime = orderExpireDatetime;
        this.payMethod = payMethod;
        this.bankCardNo = bankCardNo;
        this.bankCardPro = bankCardPro;
        this.withdrawType = withdrawType;
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.source = source;
    }

}
