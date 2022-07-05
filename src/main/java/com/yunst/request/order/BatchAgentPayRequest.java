package com.yunst.request.order;

import com.yunst.enums.GoodsType;
import com.yunst.request.BatchPay;
import com.yunst.request.OrderRequest;
import lombok.*;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BatchAgentPayRequest extends OrderRequest {
    /**
     * 商户批次号
     */
    private String bizBatchNo;

    /**
     * 批量代付列表
     * @see BatchPay
     */
    private List<BatchPay> batchPayList;

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
}
