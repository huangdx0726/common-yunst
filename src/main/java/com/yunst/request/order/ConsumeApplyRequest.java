package com.yunst.request.order;

import com.yunst.enums.GoodsType;
import com.yunst.enums.SourceType;
import com.yunst.enums.ValidateType;
import com.yunst.request.BaseOrderRequest;
import com.yunst.request.BasePayMethod;
import com.yunst.request.SplitRule;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ConsumeApplyRequest extends BaseOrderRequest {

    /**
     * 商户系统用户标识，商户系统中唯一编号。
     * 付款方
     */
    private String payerId;

    /**
     * 商户系统用户标识，商户系统中唯一编号。
     * 收款方
     */
    private String recieverId;

    /**
     * 交易验证方式
     */
    private ValidateType validateType;

    /**
     * 分账规则
     */
    private List<SplitRule> splitRule;

    /**
     * 前台通知地址
     */
    private String frontUrl;

    /**
     * 后台通知地址
     */
    private String backUrl;

    /**
     * 订单过期时间
     */
    private String orderExpireDatetime;

    /**
     * 支付方式
     */
    private List<BasePayMethod> payMethods;

    /**
     * 商品类型
     */
    private GoodsType goodsType;

    /**
     * 商户系统商品编号
     */
    private String bizGoodsNo;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品描述
     */
    private String goodsDesc;

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
    public ConsumeApplyRequest(String bizOrderNo, Long amount, Long fee, String backUrl, String summary, String extendInfo, String payerId, String recieverId, ValidateType validateType, List<SplitRule> splitRule, String frontUrl, String backUrl1, String orderExpireDatetime, List<BasePayMethod> payMethods, GoodsType goodsType, String bizGoodsNo, String goodsName, String goodsDesc, String industryCode, String industryName, SourceType source) {
        super(bizOrderNo, amount, fee, backUrl, summary, extendInfo);
        this.payerId = payerId;
        this.recieverId = recieverId;
        this.validateType = validateType;
        this.splitRule = splitRule;
        this.frontUrl = frontUrl;
        this.backUrl = backUrl1;
        this.orderExpireDatetime = orderExpireDatetime;
        this.payMethods = payMethods;
        this.goodsType = goodsType;
        this.bizGoodsNo = bizGoodsNo;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.source = source;
    }
}
