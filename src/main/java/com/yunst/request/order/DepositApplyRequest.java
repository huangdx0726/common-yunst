package com.yunst.request.order;

import com.yunst.enums.SourceType;
import com.yunst.enums.ValidateType;
import com.yunst.request.BaseOrderRequest;
import com.yunst.request.BasePayMethod;
import lombok.*;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class DepositApplyRequest extends BaseOrderRequest {
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
     * 前台通知地址
     */
    private String frontUrl;

    /**
     * 订单过期时间
     */
    private String orderExpireDatetime;

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

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 支付方式
     * 有些支出组合方式
     */
    private List<BasePayMethod> payMethods;


    @Builder
    public DepositApplyRequest(String bizOrderNo, Long amount, Long fee, String backUrl, String summary, String extendInfo, String bizUserId, String accountSetNo, ValidateType validateType, String frontUrl, String orderExpireDatetime, String industryCode, String industryName, SourceType source, String goodsName, List<BasePayMethod> payMethods) {
        super(bizOrderNo, amount, fee, backUrl, summary, extendInfo);
        this.bizUserId = bizUserId;
        this.accountSetNo = accountSetNo;
        this.validateType = validateType;
        this.frontUrl = frontUrl;
        this.orderExpireDatetime = orderExpireDatetime;
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.source = source;
        this.goodsName = goodsName;
        this.payMethods = payMethods;
    }
}
