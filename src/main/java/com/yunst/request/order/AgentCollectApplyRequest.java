package com.yunst.request.order;

import com.yunst.enums.SourceType;
import com.yunst.enums.ValidateType;
import com.yunst.request.BaseOrderRequest;
import com.yunst.request.BasePayMethod;
import com.yunst.request.Reciever;
import lombok.*;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AgentCollectApplyRequest extends BaseOrderRequest {

    /**
     * 商户系统用户标识，商户系统中唯一编号。
     * 付款人
     */
    private String payerId;

    /**
     * 收款列表
     */
    private List<Reciever> recieverList;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 商户系统商品编号
     */
    private String bizGoodsNo;

    /**
     * 业务码
     */
    private String tradeCode;

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
     * 支付方式
     * 有些支出组合方式
     */
    private List<BasePayMethod> payMethods;

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
    public AgentCollectApplyRequest(String bizOrderNo, Long amount, Long fee, String backUrl, String summary, String extendInfo, String payerId, List<Reciever> recieverList, String goodsType, String bizGoodsNo, String tradeCode, ValidateType validateType, String frontUrl, String orderExpireDatetime, List<BasePayMethod> payMethods, String goodsName, String goodsDesc, String industryCode, String industryName, SourceType source) {
        super(bizOrderNo, amount, fee, backUrl, summary, extendInfo);
        this.payerId = payerId;
        this.recieverList = recieverList;
        this.goodsType = goodsType;
        this.bizGoodsNo = bizGoodsNo;
        this.tradeCode = tradeCode;
        this.validateType = validateType;
        this.frontUrl = frontUrl;
        this.orderExpireDatetime = orderExpireDatetime;
        this.payMethods = payMethods;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.industryCode = industryCode;
        this.industryName = industryName;
        this.source = source;
    }
}
