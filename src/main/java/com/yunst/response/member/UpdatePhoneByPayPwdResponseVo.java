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
public class UpdatePhoneByPayPwdResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -8728001126596568056L;

    private UpdatePhoneByPayPwdVo signedValue;

    @Data
    public static class UpdatePhoneByPayPwdVo {
        /**
         * 商户系统用户标识，商户系统中唯一编号
         */
        private String bizUserId;

        /**
         * OK    成功
         * error 失败
         */
        private String result;

        /**
         * 新手机号
         * 如果修改失败，则为空
         */
        private String newPhone;
    }
}
