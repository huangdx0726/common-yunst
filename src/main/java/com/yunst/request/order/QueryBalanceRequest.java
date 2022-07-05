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
public class QueryBalanceRequest extends OrderRequest {
    /**
     * 商户系统用户标识，商户
     * 系统中唯一编号
     */
    private String bizUserId;

    /**
     * 账户集编号
     */
    private String accountSetNo;
}
