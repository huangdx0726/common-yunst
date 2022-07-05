package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 创建会员响应报文
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CreateMemberResponseVo extends BaseYunstResponseVo {

    private static final long serialVersionUID = 4793150331345231652L;

    private CreateMemberVo signedValue;

    @Data
    public static class CreateMemberVo {
        /**
         * 云商通用户唯一标识
         */
        private String userId;

        /**
         * 商户系统用户标识，商户 系统中唯一编号。
         */
        private String bizUserId;
    }
}
