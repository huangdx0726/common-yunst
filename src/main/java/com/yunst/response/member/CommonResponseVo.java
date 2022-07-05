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
public class CommonResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = -5829326104011720345L;

    private CommonVo signedValue;

    @Data
    public static class CommonVo {
        /**
         * 商户系统用户标识，商户系统中唯一编号
         */
        private String bizUserId;
        /**
         * 1-	成功
         * 2-	失败
         */
        private String result;
    }
}
