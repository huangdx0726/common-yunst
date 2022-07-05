package com.yunst.response.member;

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
public class BindBankCardResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -7421551611406663270L;

    private BindBankCardVo signedValue;

    @Data
    public static class BindBankCardVo {
        /**
         * 商户系统用户标识
         */
        private String bizUserId;

        /**
         * 流水号
         */
        private String tranceNum;

        /**
         * 签约协议号
         */
        private String agreementNo;

        /**
         * 申请时间
         */
        private String transDate;
    }
}
