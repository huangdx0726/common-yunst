package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class FreezeMoneyResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 4923499278487302963L;

    private FreezeMoneyVo signedValue;

    @Data
    public static class FreezeMoneyVo {
        /**
         * 商户冻结金额订单号
         */
        private String bizFreezenNo;

        /**
         * 冻结金额
         */
        private Long amount;
    }
}
