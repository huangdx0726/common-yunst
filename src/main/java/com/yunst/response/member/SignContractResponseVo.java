package com.yunst.response.member;

import com.yunst.response.BaseYunstResponseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 签约响应报文
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class SignContractResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 7470308930641634884L;

    private SignContractVo signedValue;

    @Data
    public static class SignContractVo {
        /**
         * 会员电子协议编号
         */
        private String ContractNo;

        /**
         * 商户系统用户标识，商户 系统中唯一编号。
         */
        private String bizUserId;

        /**
         * 签订结果
         */
        private String result;
    }
}
