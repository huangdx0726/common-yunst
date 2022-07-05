package com.yunst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分账规则
 * @author dudangman
 */
@Data
@Builder
@AllArgsConstructor
public class SplitRule implements Serializable {
    private static final long serialVersionUID = -6351002472346889358L;
    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 如果向会员分账，不上送，默认为唯一托管账户集。如果向平台分账，请填写平台的标准账户集编号
     * （不支持 100003-准备金额度账户集）
     */
    private String accountSetNo;

    /**
     * 金额，单位：分
     */
    private Long amount;

    /**
     * 手续费，内扣，单位：分
     */
    private Long fee;

    /**
     * 备注，最长 50 个字符
     */
    private String remark;

    /**
     * 分账列表
     */
    private List<SplitRule> splitRuleList;
}
