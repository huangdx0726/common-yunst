package com.yunst.request.paymethod.out;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 存管银行单笔代付(华瑞银行等）
 * @author dudangman
 */
public class WithdrawStandardBank extends BasePayMethod {
    public WithdrawStandardBank(WithdrawStandardBankRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @Builder
    public static class WithdrawStandardBankRequest extends BasePayMethodRequest {
        /**
         * 支付行号，12 位数字
         */
        private String unionBank;
        /**
         * 开户行支行名称
         */
        private String bankName;
        /**
         * 省
         */
        private String province;
        /**
         * 市
         */
        private String city;
        /**
         * 收款人账号
         */
        private String PAYEE_ACCT_NO;
        /**
         * 收款人户名
         */
        private String PAYEE_ACCT_NAME;
        /**
         * 金额
         */
        private String AMOUNT;
        /**
         * 摘要
         */
        private String SUMMARY;
        /**
         * 取收款人账号、收款人户名、金额、
         * 摘要字段用银行分配给商户的商户私钥签名
         */
        private String SIGNED_MSG_MER;
    }
}
