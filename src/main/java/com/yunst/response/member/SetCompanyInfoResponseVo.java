package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 设置企业响应报文
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SetCompanyInfoResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -2920520683922129470L;

    private SetCompanyInfoVo signedValue;

    @Data
    public static class SetCompanyInfoVo {
        /**
         * 失败原因
         */
        private String failReason;

        /**
         * 商户系统用户标识，商户 系统中唯一编号。
         */
        private String bizUserId;

        /**
         * 签订结果
         */
        private String result;

        /**
         * 备注
         */
        private String remark;
    }
}
