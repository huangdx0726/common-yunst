package com.yunst.request.order;

import com.yunst.enums.GoodsType;
import com.yunst.request.BaseOrderRequest;
import com.yunst.request.CollectPay;
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
public class SignalAgentPayRequest extends BaseOrderRequest {

    /**
     * 源托管代收订单付款信息
     */
    private List<CollectPay> collectPayList;

    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 收款人的账户集编号
     */
    private String accountSetNo;

    /**
     * 分账规则
     * 支持分账到会员或者平台账户。
     * 分账规则：分账层级数<=3，分
     * 账总会员数<=10
     */
    private List<SplitRule> splitRuleList;

    /**
     * 商品类型
     */
    private GoodsType goodsType;

    /**
     * 商户系统商品编号
     */
    private String bizGoodsNo;

    /**
     * 业务码
     */
    private String tradeCode;

    @Builder
    public SignalAgentPayRequest(String bizOrderNo, Long amount, Long fee, String backUrl, String summary, String extendInfo, List<CollectPay> collectPayList, String bizUserId, String accountSetNo, List<SplitRule> splitRuleList, GoodsType goodsType, String bizGoodsNo, String tradeCode) {
        super(bizOrderNo, amount, fee, backUrl, summary, extendInfo);
        this.collectPayList = collectPayList;
        this.bizUserId = bizUserId;
        this.accountSetNo = accountSetNo;
        this.splitRuleList = splitRuleList;
        this.goodsType = goodsType;
        this.bizGoodsNo = bizGoodsNo;
        this.tradeCode = tradeCode;
    }
}
