package com.yunst.request.order;

import com.yunst.request.OrderRequest;
import lombok.*;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationTransferRequest extends OrderRequest {

    /**
     * 商户系统转账订单号
     */
    private String bizTransferNo;

    /**
     * 源账户集编号
     */
    private String sourceAccountSetNo;

    /**
     * 目标商户系统用户标识
     */
    private String targetBizUserId;

    /**
     * 目标账户集编号
     */
    private String targetAccountSetNo;

    /**
     * 金额
     */
    private Long amount;

    /**
     * 扩展信息
     */
    private String extendInfo;
}
