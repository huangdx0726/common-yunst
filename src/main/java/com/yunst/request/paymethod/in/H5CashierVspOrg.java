package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 收银宝H5 收银台_集团
 * 入金
 * @author dudangman
 */
public class H5CashierVspOrg extends BasePayMethod {
    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    public H5CashierVspOrg(H5CashierVspOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @EqualsAndHashCode(callSuper = true)
    @Setter
    @Getter
    public static class H5CashierVspOrgRequest extends H5CashierVsp.BaseH5CashierVspRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public H5CashierVspOrgRequest(Long amount, String extendParams, LimitPay limitPay, String goods_tag, String benefitdetail, String subbranch, String vspCusid) {
            super(amount, extendParams, limitPay, goods_tag, benefitdetail, subbranch);
            this.vspCusid = vspCusid;
        }
    }

}
