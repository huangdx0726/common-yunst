package com.yunst.request.order;

import com.yunst.request.OrderRequest;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FreezeMoneyRequest extends OrderRequest {
    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 商户冻结金额订单号
     */
    private String bizFreezenNo;

    /**
     * 账户集编号
     */
    private String accountSetNo;

    /**
     * 冻结金额
     * 单位：分
     */
    private Long amount;
}
