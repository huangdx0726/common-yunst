package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 批量托管代付
 * @author dudangman
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BatchPay implements Serializable {
    private static final long serialVersionUID = -6202523649394082809L;

    /**
     * 商户订单号（支付订单） 全局唯一，不可重复
     * 不可包含“|”字符
     */
    private String bizOrderNo;

    /**
     * 源托管代收订单付款信息最多支持100个
     */
    private List<CollectPay> collectPayList;

    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 收款方的账户集编号
     */
    private String accountSetNo;

    /**
     * 后台通知地址
     */
    private String backUrl;

    /**
     * 金额，单位：分
     */
    private Long amount;

    /**
     * 手续费，单位：分。
     * 内扣，如果不存在，则填 0。
     * 如amount 为 100，fee 为 2，实际到账金额为 98。
     * *代付成功后，代付手续费不支持退款。
     */
    private Long fee;

    /**
     * 支持分账到会员或者平台账户。
     * 分账规则：分账层级数<=3，分账总会员数<=10
     */
    private List<SplitRule> splitRuleList;

    /**
     * 不可包含“|”及换行符等特殊字符，最多 50 个字符
     */
    private String summary;

    /**
     * 接口将原样返回，不可包含“|”及换行符等特殊字符，最多50 个字符
     */
    private String extendInfo;
}
