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
public class UnbindPhoneResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 7384920376290528210L;

    private UnBindPhoneVo signedValue;

    @Data
    public static class UnBindPhoneVo {
        /**
         * 商户系统用户标识，商户系统中唯一编号
         */
        private String bizUserId;

        /**
         * OK-	成功
         * error-	失败
         */
        private String result;

        /**
         * 原手机号码
         */
        private String phone;
    }
}
