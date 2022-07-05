package com.yunst.response.order;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class ApplicationTransferResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -1801679024827564234L;

    private ApplicationTransferVo signedValue;

    @Data
    public static class ApplicationTransferVo {
        /**
         * 云商通转账订单号
         */
        private String transferNo;

        /**
         * 商户系统转账订单号
         */
        private String bizTransferNo;

        /**
         * 金额
         */
        private Long amount;

        /**
         * 扩展信息
         */
        private String extendInfo;
    }
}
