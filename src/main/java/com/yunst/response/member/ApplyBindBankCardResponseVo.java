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
public class ApplyBindBankCardResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 9019838475162408901L;

    private ApplyBindBankCardVo signedValue;

    @Data
    public static class ApplyBindBankCardVo {
        /**
         * 商户系统唯一ID
         */
        private String bizUserId;

        /**
         * 流水号
         */
        private String tranceNum;

        /**
         * 申请时间
         */
        private String transDate;

        /**
         * 银行名称
         */
        private String bankName;

        /**
         * 银行代码
         */
        private String bankCode;

        /**
         * 银行卡类型
         */
        private Long cardType;
    }
}
