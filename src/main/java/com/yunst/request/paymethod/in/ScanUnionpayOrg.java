package com.yunst.request.paymethod.in;

import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝银联扫码支付(正扫)_集团
 * @author dudangman
 */
public class ScanUnionpayOrg extends BasePayMethod {
    public ScanUnionpayOrg(ScanUnionPayOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return null;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    public static class ScanUnionPayOrgRequest extends ScanUnionpay.BaseScanUnionPayRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public ScanUnionPayOrgRequest(Long amount, String extendParams, LimitPay limitPay, String vspCusid) {
            super(amount, extendParams, limitPay);
            this.vspCusid = vspCusid;
        }
    }
}
