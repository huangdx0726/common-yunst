package com.yunst.request.paymethod.in;

import com.yunst.enums.IdentityType;
import com.yunst.enums.LimitPay;
import com.yunst.request.BasePayMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 收银宝微信扫码支付( 正扫)_集团
 * @author dudangman
 */
public class ScanWeixinOrg extends BasePayMethod {
    public ScanWeixinOrg(ScanWeiXinOrgRequest payMethodRequest) {
        super(payMethodRequest);
    }

    @Override
    public String getSimpleName() {
        return this.getClass().getSimpleName();
    }

    @EqualsAndHashCode(callSuper = true)
    @NoArgsConstructor
    @Data
    public static class ScanWeiXinOrgRequest extends ScanWeixin.BaseScanRequest {
        /**
         * 收银宝子商户号
         */
        private String vspCusid;

        @Builder
        public ScanWeiXinOrgRequest(Long amount, String extendParams, LimitPay limitPay, String idNo, String name, IdentityType certType, String vspCusid) {
            super(amount, extendParams, limitPay, idNo, name, certType);
            this.vspCusid = vspCusid;
        }
    }
}
