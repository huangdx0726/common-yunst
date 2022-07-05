package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 发送验证码及绑定手机响应报文
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class VerificationCodeResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 5769355184494538671L;

    private VerificationCodeVo signedValue;

    @Data
    public static class VerificationCodeVo {
        /**
         * 手机号
         */
        private String phone;

        /**
         * 商户系统用户标识，商户 系统中唯一编号。
         */
        private String bizUserId;
    }
}
