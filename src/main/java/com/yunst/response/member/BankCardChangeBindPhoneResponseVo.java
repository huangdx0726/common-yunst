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
public class BankCardChangeBindPhoneResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 3601939571741939992L;

    private BankCardChangeBindPhoneVo signedValue;

    @Data
    public static class BankCardChangeBindPhoneVo {
        /**
         * 商户系统唯一ID
         */
        private String bizUserId;

        /**
         * 流水号
         */
        private String tranceNum;

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
         * 1-储蓄卡
         * 2-信用卡
         */
        private Integer cardType;
    }
}
