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
public class CreateBanKSubAcctNoResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -6193536052285982205L;

    private CreateBanKSubAcctNoVo signedValue;

    @Data
    public static class CreateBanKSubAcctNoVo {
        /**
         * 会员子账号
         */
        private String subAcctNo;

        /**
         * 账户集编号
         */
        private String accountSetNo;

        /**
         * 商户系统用户标识
         */
        private String bizUserId;
    }
}
