package com.yunst.response.member;

import com.yunst.annotation.DecryptRsa;
import com.yunst.response.BaseYunstResponseVo;
import lombok.*;

import java.util.List;

/**
 * @author dudangman
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class QueryBankCardResponseVo extends BaseYunstResponseVo {
    private static final long serialVersionUID = 6288012449470134824L;

    private QueryBankCardVo signedValue;

    @Setter
    @Getter
    public static class QueryBankCardVo {
        private List<QueryBankCard> bindCardList;
    }

    @Data
    public static class QueryBankCard {
        /**
         * 银行卡号，RSA 加密，详细
         */
        @DecryptRsa
        private String bankCardNo;

        /**
         * 银行名称
         */
        private String bankName;

        /**
         * 绑定时间
         */
        private String bindTime;

        /**
         * 签约协议号
         * 仅绑卡方式 6 或 7 时返回
         */
        private String agreementNo;

        /**
         * 银行卡类型
         */
        private Integer cardType;

        /**
         * 绑定状态
         */
        private Integer bindState;

        /**
         * 银行预留手机号码（仅四要素绑定的银行卡返回）
         */
        private String phone;

        /**
         * 若为企业对公户返回 0
         *
         */
        private Integer bindMethod;

        /**
         * 银行卡/账户属性
         * 0：个人银行卡
         * 1：企业对公账户
         * @see com.yunst.enums.BankCardPro
         */
        private Integer bankCardPro;

        /**
         * 开户行地区代码
         */
        private String bankCityNo;

        /**
         * 开户行支行名称
         */
        private String branchBankName;

        /**
         * 支付行号，12 位数字
         */
        private String unionBank;

        /**
         * 支付行号，12 位数字
         */
        private String province;

        /**
         * 开户行所在市
         */
        private String city;
    }
}
