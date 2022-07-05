package com.yunst.request.order;

import com.yunst.enums.TradeType;
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
public class QueryInExpDetailRequest extends OrderRequest {

    /**
     * 商户系统用户标识
     */
    private String bizUserId;

    /**
     * 账户集编号
     */
    private String accountSetNo;

    /**
     * 开始日期
     */
    private String dateStart;

    /**
     * 结束日期
     */
    private String dateEnd;

    /**
     * 起始位置
     */
    private Long startPosition;

    /**
     * 查询条数
     */
    private Long queryNum;

    /**
     * 交易类型
     */
    private TradeType tradeType;
}
