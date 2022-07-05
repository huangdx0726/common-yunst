package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.*;

/**
 * 收银宝银联JS 支付_集团
 * @author dudangman
 */
public class UnionpayJsOrg extends BasePayMethod {
    public UnionpayJsOrg(UnionPayJsOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @Setter
    @Getter
    public static class UnionPayJsOrgRequest extends UnionpayJs.BaseUnionPayJsRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public UnionPayJsOrgRequest(Long amount, String extendParams, String acct, LimitPay limitPay, String cusip, String vspCusid) {
            super(amount, extendParams, acct, limitPay, cusip);
            this.vspCusid = vspCusid;
        }
    }
}
