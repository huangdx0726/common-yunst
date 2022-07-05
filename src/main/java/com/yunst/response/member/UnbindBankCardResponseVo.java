package com.yunst.response.member;

import com.yunst.annotation.DecryptRsa;
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
public class UnbindBankCardResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 5793942991822329184L;

    private UnbindBankCardVo signedValue;

    @Data
    public static class UnbindBankCardVo {
        /**
         * 商户系统用户标识
         */
        private String bizUserId;

        /**
         * 银行卡号
         */
        @DecryptRsa
        private String cardNo;
    }
}
