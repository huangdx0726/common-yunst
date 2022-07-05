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
public class BatchAgentPayResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -1747764615191809791L;

    private BatchAgentPayVo signedValue;

    @Data
    public static class BatchAgentPayVo {
        /**
         * 商户批次号
         */
        private String bizBatchNo;
    }
}
