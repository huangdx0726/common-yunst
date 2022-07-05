package com.yunst.request.paymethod.in;

import com.yunst.request.BasePayMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 收银宝QQ 钱包JS 支付_集团
 * @author dudangman
 */
public class QqWalletOrg extends BasePayMethod {
    public QqWalletOrg(QqWalletOrgRequest payMethodRequest) {
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
    public static class QqWalletOrgRequest extends BasePayMethodRequest {
        /**
         * 支付金额
         * 单位：分
         */
        private Long amount;

        /**
         * 渠道拓展参数，最长 1000 字符
         */
        private String extendParams;

        /**
         * 收银宝子商户号
         */
        private String vspCusid;
    }
}
